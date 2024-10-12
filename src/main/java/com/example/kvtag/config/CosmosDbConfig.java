package com.example.kvtag.config;

import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.DirectConnectionConfig;
import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration;
import com.azure.spring.data.cosmos.config.CosmosConfig;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CosmosDbConfig extends AbstractCosmosConfiguration {

    @Resource
    private CosmosDbProperties cosmosDbProperties;

    @Bean
    public CosmosClientBuilder cosmosClientBuilder() {
        DirectConnectionConfig directConnectionConfig = DirectConnectionConfig.getDefaultConfig();
        return new CosmosClientBuilder()
                .endpoint(cosmosDbProperties.getUri())
                .key(cosmosDbProperties.getKey())
                .directMode(directConnectionConfig);
    }

    @Bean
    @Override
    public CosmosConfig cosmosConfig() {
        return CosmosConfig.builder()
                .enableQueryMetrics(cosmosDbProperties.getPopulateQueryMetrics())
                .build();
    }

    @Override
    protected String getDatabaseName() {
        return cosmosDbProperties.getDatabase();
    }
}
