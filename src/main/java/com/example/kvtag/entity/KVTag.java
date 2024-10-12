package com.example.kvtag.entity;

import ai.qworks.dao.annotations.Mandatory;
import ai.qworks.dao.annotations.SharedObject;
import ai.qworks.dao.base.BaseEntity;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.CosmosUniqueKey;
import com.azure.spring.data.cosmos.core.mapping.CosmosUniqueKeyPolicy;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Container(
        containerName = "KVTag"
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
public class KVTag extends BaseEntity {
    @Mandatory
    private String name;
    private List<String> values;
}
