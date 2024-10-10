package com.example.kvtag;

import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCosmosRepositories
public class KvtagApplication {

	public static void main(String[] args) {
		SpringApplication.run(KvtagApplication.class, args);
	}

}
