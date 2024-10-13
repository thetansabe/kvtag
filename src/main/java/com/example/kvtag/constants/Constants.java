package com.example.kvtag.constants;

import java.util.ArrayList;
import java.util.List;

public class Constants {
    public static final String MODEL_PATH = "com.example.kvtag.models";

    public static final List<String> categoryFilterStrings = new ArrayList<>(){
        {
            add("name");
            add("priceListName");
            add("type");
            add("kvTags");
        }
    };

    public static final List<String> productFilterStrings = new ArrayList<>(){
        {
            add("name");
            add("productGroupName");
            add("productCode");
            add("model");
            add("productFamily");
            add("productUoM");
            add("type");
            add("productCode");
            add("inclusionCriteria");
            add("kvTags");
        }
    };

    public static final List<String> priceListItemFilterStrings = new ArrayList<>(){
        {
            add("name");
            add("productName");
            add("productType");
            add("priceType");
            add("priceMethod");
            add("priceUOM");
            add("expressionCriteria");
            add("sellingUom");
            add("adjustmentType");
            add("productCode");
            add("model");
            add("featureGroupName");
            add("rampType");
            add("kvTags");
        }
    };
}
