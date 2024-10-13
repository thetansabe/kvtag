package com.example.kvtag.services;

import ai.qworks.dao.nontransaction.Category;
import ai.qworks.dao.nontransaction.PriceListItem;
import com.example.kvtag.models.Product;
import ai.qworks.dao.nontransaction.CatalogTree;
import com.example.kvtag.util.FormulaEvaluator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CatalogTreeService {
    // MOCK DATA - DO NOT USE
    public static CatalogTree mockCatalogTree() {
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
                setData(pli1);
                setType("PriceListItem");
            }
        };

        CatalogTree node2 = new CatalogTree(){
            {
                setData(pli2);
                setType("PriceListItem");
            }
        };

        CatalogTree node3 = new CatalogTree(){
            {
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
                setData(product2);
                setType("Product");
            }
        };

        CatalogTree node5 = new CatalogTree(){
            {
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
                setData(anscCate2);
                setType("Category");
            }
        };

        CatalogTree node7 = new CatalogTree(){
            {
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
                setData(pli3);
                setType("PriceListItem");
            }
        };

        CatalogTree node9 = new CatalogTree(){
            {
                setData(pli4);
                setType("PriceListItem");
            }
        };

        CatalogTree node10 = new CatalogTree(){
            {
                setData(pli5);
                setType("PriceListItem");
            }
        };

        CatalogTree node11 = new CatalogTree(){
            {
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

    // DO NOT USE STATIC IN REAL CASE
    private static void dfsAssembleByFilter(String filter, String objectType, CatalogTree node, List<CatalogTree> result){
        if(objectType.equalsIgnoreCase(node.getType())
            && node.getData() != null
            && FormulaEvaluator.evaluateFormula(filter, node.getData(), objectType))
        {
            result.add(node);
        }

        if(node.getChild() != null){
            for(CatalogTree child : node.getChild()){
                dfsAssembleByFilter(filter, objectType, child, result);
            }
        }
    }

    // DO NOT USE STATIC IN REAL CASE
    public static List<CatalogTree> getCatalogDataByFilter(String filter, String objectType, CatalogTree root){
        List<CatalogTree> result = new ArrayList<>();
        dfsAssembleByFilter(filter, objectType, root, result);
        return result;
    }


    public static boolean searchCatalogTree(CatalogTree rootNode, String text) {
        if (isValidComparisonCondition(text)) {
            return searchTreeByCondition(rootNode, text);
        }
        return false;
    }

    private static boolean isValidComparisonCondition(String text) {
        return text.matches("^(>=|<=|>|<|=)?\\s*\\d+(\\.\\d+)?$");
    }

    private static boolean searchTreeByCondition(CatalogTree node, String condition) {
        List<String> fieldNames = List.of("basePrice", "extendedPrice", "baseExtendedPrice");
        if ("PriceListItem".equals(node.getType())) {
            PriceListItem item = (PriceListItem) node.getData();
            for (String fieldName : fieldNames) {
                try {
                    Field field = PriceListItem.class.getDeclaredField(fieldName);
                    field.setAccessible(true);

                    double fieldValue = (Double) field.get(item);

                    return evaluateCondition(fieldValue, condition);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

    // (>=, <=, >, <, =)
    private static boolean evaluateCondition(double value, String condition) {
        condition = condition.replaceAll("\\s+", "");

        String operator = condition.replaceAll("\\d+.*", "");
        String compareValueStr = condition.replaceAll("[^\\d.]", "");

        if (operator.isEmpty()) {
            operator = "=";
        }

        double compareValue = Double.parseDouble(compareValueStr);

        switch (operator) {
            case ">":
                return value > compareValue;
            case "<":
                return value < compareValue;
            case ">=":
                return value >= compareValue;
            case "<=":
                return value <= compareValue;
            case "=":
            case "==":
                return value == compareValue;
            default:
                return false;
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        CatalogTree tree = mockCatalogTree();
        searchCatalogTree(tree, ">= 300");
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(tree);
        System.out.println(jsonString);
    }

}
