package com.example.kvtag.models;

import ai.qworks.dao.annotations.Mandatory;
import ai.qworks.dao.annotations.SharedObject;
import ai.qworks.dao.base.BaseEntity;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.CosmosUniqueKey;
import com.azure.spring.data.cosmos.core.mapping.CosmosUniqueKeyPolicy;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Container(
        containerName = "Product"
)
@JsonIgnoreProperties(
        ignoreUnknown = true
)
@SharedObject
@CosmosUniqueKeyPolicy(
        uniqueKeys = {@CosmosUniqueKey(
                paths = {"/name", "/productCode"}
        )}
)
@Getter
@Setter
public class Product extends BaseEntity {
    private static final long serialVersionUID = 6529249104361519153L;
    private String productFamilyId;
    private String productFamily;
    private String productGroupId;
    @Mandatory
    private String type;
    @Mandatory
    private String productCode;
    private String minQuantity;
    private String maxQuantity;
    private String defaultQuantity;
    private String autoUpdateQuantity;
    private String inclusionCriteria;
    private String productGroupName;
    private String image;
    public boolean isSearchable;
    @JsonProperty("isDefaultOption")
    private boolean isDefaultOption;
    public boolean isRequired;
    public boolean isHasAttributes;
    public long attributeGroupCount;
    @Mandatory
    @PartitionKey
    private String model;
    public boolean isHasFeatureAttributeGroup;
    public boolean addOn;
    private String productTypeId;
    private String relatedPriceListId;
    private String productUoM;

    private List<KVTag> kvTags;

    public String toFilterableString() {
        StringBuilder sb = new StringBuilder();

        if(this.kvTags != null && !this.kvTags.isEmpty()) {
            for(KVTag kvTag : this.kvTags) {
                sb.append(kvTag.getName());
                String values = String.join(", ", kvTag.getValues());
                if(StringUtils.isNotBlank(values)) {
                    sb.append("##").append(values).append(", ");
                }
            }
        }

        return this.productGroupName + ", " + this.productCode + ", " + this.model
                + ", " + this.productFamily + ", " + this.productUoM
                + ", " + this.type + ", " + this.productGroupId
                + ", " + this.productFamilyId + ", " + this.productCode
                + ", " + this.inclusionCriteria + ", " + sb;
    }
}