package com.example.kvtag.repositories;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.example.kvtag.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CosmosRepository<Product, String> {
}
