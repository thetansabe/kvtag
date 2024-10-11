package com.example.kvtag.repositories;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.spring.data.cosmos.repository.Query;
import com.example.kvtag.models.KVTag;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KVTagRepository extends CosmosRepository<KVTag, String> {
    Optional<KVTag> findByName(String name);

    @Query("SELECT VALUE KVTag FROM KVTag WHERE ARRAY_CONTAINS_ALL(KVTag.values, @targetValues) offset 0 limit 1")
    Optional<KVTag> findByValue(@Param("targetValues") List<String> targetValues);
}
