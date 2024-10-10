package com.example.kvtag.repositories;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.example.kvtag.models.KVTag;
import org.springframework.stereotype.Repository;

@Repository
public interface KVTagRepository extends CosmosRepository<KVTag, String> {
}
