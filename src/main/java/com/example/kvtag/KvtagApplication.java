package com.example.kvtag;

import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;
import com.example.kvtag.config.CosmosDbProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableCosmosRepositories
@EnableConfigurationProperties(value = { CosmosDbProperties.class })
public class KvtagApplication {

	public static void main(String[] args) {
		SpringApplication.run(KvtagApplication.class, args);
	}

}
