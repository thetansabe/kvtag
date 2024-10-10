package com.example.kvtag.repositories;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.example.kvtag.models.KVTag;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KVTagRepository extends CosmosRepository<KVTag, String> {
    Optional<KVTag> findByName(String name);
}
