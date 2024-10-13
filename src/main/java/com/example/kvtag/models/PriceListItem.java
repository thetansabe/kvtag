package com.example.kvtag.models;

import ai.qworks.dao.annotations.Mandatory;
import ai.qworks.dao.annotations.SharedObject;
import ai.qworks.dao.base.BaseEntity;
import ai.qworks.dto.PriceListItemObj;
import ai.qworks.dto.SubscriptionManagement;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Container(
        containerName = "PriceListItem"
)
@SharedObject
@JsonIgnoreProperties(
        ignoreUnknown = true
)
@Getter
@Setter
public class PriceListItem extends BaseEntity {
    private static final long serialVersionUID = 4161900597545680943L;
    private Double listPrice;
    @Mandatory
    private String productId;
    @Mandatory
    private String productName;
    @Mandatory
    private String productType;
    private String currencyId;
    private String currencyIsoCode;
    private Double defaultQuantity;
    private Double minQuantity;
    private Double maxQuantity;
    private Double discountedPrice;
    private Double basePrice;
    private Double extendedPrice;
    private Double baseExtendedPrice;
    private Double taxes;
    private Double shippingPrice;
    private Double sellingTerm;
    private Double adjustedNetPrice;
    private Double adjustmentValue;
    private String priceType;
    private String priceTypeId;
    private String parentId;
    @Mandatory
    private String priceMethod;
    private String priceUOM;
    private String priceUOMId;
    private String accountId;
    @Mandatory
    @PartitionKey
    private String priceListId;
    private String expressionCriteria;
    private String sellingUom;
    private String adjustmentType;
    private String adjustmentTypeId;
    @Mandatory
    private String model;
    private String modelId;
    @Mandatory
    private String sellingFrequency;
    private long startDate;
    private long endDate;
    private String featureGroupId;
    private String featureGroupName;
    private String sellingFrequencyId;
    private String priceMethodId;
    private String productCode;
    private Boolean allowManualAdjustments;
    public boolean isPriceMatrixEnabled;
    public boolean isPriceIncludedInTheBundle;
    public boolean bundleRollUp;
    public boolean bundleRollDown;
    private String rampType;
    private SubscriptionManagement subscriptionManagement;

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

        return this.productName + ", " + this.productType + ", " + this.priceType
                + ", " + this.priceMethod + ", " + this.priceUOM
                + ", " + this.expressionCriteria + ", " + this.sellingUom
                + ", " + this.adjustmentType + ", " + this.productCode
                + ", " + this.model + ", " + this.featureGroupName +
                ", " + this.productCode + ", " + this.rampType + ", " + sb;
    }
}
