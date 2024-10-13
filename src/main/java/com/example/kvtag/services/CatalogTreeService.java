package com.example.kvtag.services;

import com.example.kvtag.constants.Constants;
import com.example.kvtag.models.Category;
import com.example.kvtag.models.PriceListItem;
import com.example.kvtag.models.KVTag;
import com.example.kvtag.models.Product;
import ai.qworks.dao.nontransaction.CatalogTree;
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
    // MOCK DATA - DO NOT USE
    public static CatalogTree mockCatalogTree() {
        KVTag kvTag1 = new KVTag(){
            {
                setId("kvTag1");
                setName("HI");
                setValues(new ArrayList<>(){
                    {
                        add("AB");
                        add("IK");
                    }
                });
            }
        };

        KVTag kvTag2 = new KVTag(){
            {
                setId("kvTag2");
                setName("BG");
                setValues(new ArrayList<>(){
                    {
                        add("CNS");
                        add("IMH");
                    }
                });
            }
        };

        PriceListItem pli1 = new PriceListItem(){
            {
                setId("pli1");
                setBasePrice(100.0);
            }
        };

        PriceListItem pli2 = new PriceListItem(){
            {
                setId("pli2");
                setBasePrice(200.0);
            }
        };

        PriceListItem pli3 = new PriceListItem(){
            {
                setId("pli3");
                setBasePrice(300.0);
            }
        };

        PriceListItem pli4 = new PriceListItem(){
            {
                setId("pli4");
                setBasePrice(400.0);
            }
        };

        PriceListItem pli5 = new PriceListItem(){
            {
                setId("pli5");
                setBasePrice(500.0);
                setKvTags(new ArrayList<>(){
                    {
                        add(kvTag1);
                        add(kvTag2);
                    }
                });
            }
        };

        Product product1 = new Product(){
            {
                setId("product1");
                setProductCode("product1");
                setModel("furniture");
                setProductFamily("xyz");
            }
        };

        Product product2 = new Product(){
            {
                setId("product2");
                setProductCode("product2");
            }
        };

        Product product3 = new Product(){
            {
                setId("product3");
                setProductCode("product3");
            }
        };


        Product product4 = new Product(){
            {
                setId("product4");
                setProductCode("product4");
                setKvTags(new ArrayList<>(){
                    {
                        add(kvTag1);
                        add(kvTag2);
                    }
                });
            }
        };

        Product product5 = new Product(){
            {
                setId("product5");
                setProductCode("product5");
                setModel("furniture");
                setProductFamily("xyz");
            }
        };

        Category anscCate1 = new Category(){
            {
                setId("anscCate1");
                setKvTags(new ArrayList<>(){
                    {
                        add(kvTag1);
                        add(kvTag2);
                    }
                });
            }
        };

        Category anscCate2 = new Category(){
            {
                setId("anscCate2");
            }
        };

        Category anscCate3 = new Category(){
            {
                setId("anscCate3");
            }
        };

        Category primordialCate1 = new Category(){
            {
                setId("primordialCate1");
            }
        };

        Category primordialCate2 = new Category(){
            {
                setId("primordialCate2");
            }
        };

        Category primordialCate3 = new Category(){
            {
                setId("primordialCate3");
            }
        };

        CatalogTree node1 = new CatalogTree(){
            {
                setId("node1");
                setData(pli1);
                setType("PriceListItem");
            }
        };

        CatalogTree node2 = new CatalogTree(){
            {
                setId("node2");
                setData(pli2);
                setType("PriceListItem");
            }
        };

        CatalogTree node3 = new CatalogTree(){
            {
                setId("node3");
                setData(product1);
                setType("Product");
                setChild(new Vector<>(){
                    {
                        add(node1);
                        add(node2);
                    }
                });
            }
        };

        CatalogTree node4 = new CatalogTree(){
            {
                setId("node4");
                setData(product2);
                setType("Product");
            }
        };

        CatalogTree node5 = new CatalogTree(){
            {
                setId("node5");
                setData(anscCate1);
                setType("Category");
                setChild(new Vector<>(){
                    {
                        add(node3);
                        add(node4);
                    }
                });
            }
        };

        CatalogTree node6 = new CatalogTree(){
            {
                setId("node6");
                setData(anscCate2);
                setType("Category");
            }
        };

        CatalogTree node7 = new CatalogTree(){
            {
                setId("node7");
                setData(primordialCate1);
                setType("Category");
                setChild(new Vector<>(){
                    {
                        add(node5);
                        add(node6);
                    }
                });
            }
        };

        CatalogTree node8 = new CatalogTree(){
            {
                setId("node8");
                setData(pli3);
                setType("PriceListItem");
            }
        };

        CatalogTree node9 = new CatalogTree(){
            {
                setId("node9");
                setData(pli4);
                setType("PriceListItem");
            }
        };

        CatalogTree node10 = new CatalogTree(){
            {
                setId("node10");
                setData(pli5);
                setType("PriceListItem");
            }
        };

        CatalogTree node11 = new CatalogTree(){
            {
                setId("node11");
                setData(product3);
                setType("Product");
                setChild(new Vector<>(){
                    {
                        add(node8);
                    }
                });
            }
        };

        CatalogTree node12 = new CatalogTree(){
            {
                setId("node12");
                setData(product4);
                setType("Product");
                setChild(new Vector<>(){
                    {
                        add(node9);
                    }
                });
            }
        };

        CatalogTree node13 = new CatalogTree(){
            {
                setId("node13");
                setData(product5);
                setType("Product");
                setChild(new Vector<>(){
                    {
                        add(node10);
                    }
                });
            }
        };

        CatalogTree node14 = new CatalogTree(){
            {
                setId("node14");
                setData(primordialCate2);
                setType("Category");
                setChild(new Vector<>(){
                    {
                        add(node11);
                        add(node12);
                        add(node13);
                    }
                });
            }
        };

        CatalogTree node15 = new CatalogTree(){
            {
                setId("node15");
                setData(primordialCate3);
                setType("Category");
            }
        };

        return new CatalogTree(){
            {
                setId("root");
                setData(new Category(){
                    {
                        setId("rootCategory");
                    }
                });
                setType("Category");
                setChild(new Vector<>(){
                    {
                        add(node7);
                        add(node14);
                        add(node15);
                    }
                });
            }
        };
    }

    private static boolean isStringExistInCatalogData(String input, CatalogTree node){
        List<String> filterFields = new ArrayList<>();

        switch (node.getType()){
            case "Category":
                filterFields = Constants.categoryFilterStrings;
                break;
            case "Product":
                filterFields = Constants.productFilterStrings;
                break;
            case "PriceListItem":
                filterFields = Constants.priceListItemFilterStrings;
                break;
            default:
                return false;
        }

        StringBuilder sb = new StringBuilder();

        for(String filterField : filterFields){
            if(!(node.getData() instanceof LinkedHashMap<?, ?>))
                continue;

            var lHashMap = (LinkedHashMap<String, Object>) node.getData();

            if("kvTags".equalsIgnoreCase(filterField)){
                var kvTags = lHashMap.get(filterField);
                if(kvTags != null && kvTags instanceof List<?>){
                    for(LinkedHashMap<String, Object> kvTag : (List<LinkedHashMap<String, Object>>) kvTags){
                        sb.append(kvTag.get("name")).append("##");
                        String values = String.join(", ", (List<String>) kvTag.get("values"));
                        if(StringUtils.isNotBlank(values)){
                            sb.append(values).append(", ");
                        }
                    }
                }
            }else{
                var value = lHashMap.get(filterField);
                sb.append(value).append(", ");
            }
        }

        return StringUtils.containsIgnoreCase(sb.toString(), input);
    }

    // DO NOT USE STATIC IN REAL CASE
    public static void dfsAssembleByFilter(String input, CatalogTree node){
        if(node.getData() == null || !isStringExistInCatalogData(input, node)){
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
