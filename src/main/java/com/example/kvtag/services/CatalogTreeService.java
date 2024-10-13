package com.example.kvtag.services;

import com.example.kvtag.constants.Constants;
import ai.qworks.dao.nontransaction.CatalogTree;
import com.example.kvtag.util.NumberFilterEvaluator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Vector;

@Slf4j
@Service
public class CatalogTreeService {

    // DO NOT USE STATIC IN REAL CASE
    private static boolean isStringExistInCatalogData(String input, CatalogTree node){
        StringBuilder sb = new StringBuilder();

        if(!(node.getData() instanceof LinkedHashMap<?, ?>))
            return false;

        var lHashMap = (LinkedHashMap<String, Object>) node.getData();
        for(var item : lHashMap.entrySet()){
            if(item.getKey() != null && item.getKey().toLowerCase().endsWith("id"))
                continue;

            if("kvTags".equalsIgnoreCase(item.getKey())){
                var kvTags = item.getValue();
                if(kvTags instanceof List<?>){
                    for(LinkedHashMap<String, Object> kvTag : (List<LinkedHashMap<String, Object>>) kvTags){
                        if(kvTag == null || (kvTag.get("name") == null && kvTag.get("values") == null)){
                            continue;
                        }
                        sb.append(kvTag.get("name")).append("##");
                        String values = String.join(", ", (List<String>) kvTag.get("values"));
                        if(StringUtils.isNotBlank(values)){
                            sb.append(values).append(", ");
                        }
                    }
                }
            }else{
                var value = item.getValue();
                if(value == null || StringUtils.isBlank(value.toString())){
                    continue;
                }
                sb.append(value).append(", ");
            }
        }

        return StringUtils.containsIgnoreCase(sb.toString(), input);
    }

    // DO NOT USE STATIC IN REAL CASE
    private static boolean isMatchingNumberInput(CatalogTree node, String condition) {
        // one of the fields in the list should match the condition
        for (String fieldName : Constants.fieldsForPriceListItemSearch) {
            if(!(node.getData() instanceof LinkedHashMap<?, ?>))
                continue;

            var lHashMap = (LinkedHashMap<String, Object>) node.getData();

            var fieldValue = lHashMap.get(fieldName);

            if(fieldValue instanceof Integer){
                fieldValue = ((Integer) fieldValue).doubleValue();
                if(NumberFilterEvaluator.evaluateCondition((Double) fieldValue, condition)){
                    return true;
                }
            }
        }

        return false;
    }

    // DO NOT USE STATIC IN REAL CASE
    private static boolean isMatchingInput(CatalogTree node, String text) {
        if (NumberFilterEvaluator.isSearchingByNumber(text)) {
            // search for number only apply for PriceListItem
            if("PriceListItem".equalsIgnoreCase(node.getType()))
                return isMatchingNumberInput(node, text);
            return false;
        }

        return isStringExistInCatalogData(text, node);
    }

    // DO NOT USE STATIC IN REAL CASE
    public static void dfsAssembleByFilter(String input, CatalogTree node){
        if(node.getData() == null || !isMatchingInput(node, input)){
            node.setIsActive(false);
        }

        if(node.getChild() != null && !node.getChild().isEmpty()){
            for(CatalogTree child : node.getChild()){
                dfsAssembleByFilter(input, child);
            }

            // if exist one child is active, then the parent is active
            // update the parent node
            Vector<CatalogTree> children = new Vector<>();
            for(CatalogTree child : node.getChild()){
                if(child.getIsActive()){
                    node.setIsActive(true);
                    children.add(child);
                }
            }
            node.setChild(children);
        }
    }

    public List<CatalogTree> globalSearch(String input, List<CatalogTree> roots){
        List<CatalogTree> result = new ArrayList<>();
        for(CatalogTree root : roots){
            dfsAssembleByFilter(input, root);
            if(root.getIsActive()){
                result.add(root);
            }
        }
        return result;
    }
}
