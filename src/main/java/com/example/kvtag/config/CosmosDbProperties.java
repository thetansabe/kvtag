package com.example.kvtag.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.data.cosmos")
@Getter
@Setter
public class CosmosDbProperties {

    private String uri;

    private String key;

    private Boolean populateQueryMetrics;

    private String database;

}
