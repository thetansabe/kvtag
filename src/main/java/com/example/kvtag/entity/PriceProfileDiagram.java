package com.example.kvtag.entity;

import ai.qworks.dao.annotations.SharedObject;
import ai.qworks.dao.base.BaseEntity;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.CosmosUniqueKey;
import com.azure.spring.data.cosmos.core.mapping.CosmosUniqueKeyPolicy;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;

@Container(
        containerName = "PriceProfileDiagram"
)
@JsonIgnoreProperties(
        ignoreUnknown = true
)
@SharedObject
@CosmosUniqueKeyPolicy(
        uniqueKeys = {@CosmosUniqueKey(
                paths = {"/name"}
        )}
)
@Getter
@Setter
public class PriceProfileDiagram extends BaseEntity {

    private JsonNode edges;

    private JsonNode nodes;

}