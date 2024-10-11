package com.example.kvtag.services;

import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.CosmosContainer;
import com.azure.cosmos.CosmosDatabase;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.azure.cosmos.util.CosmosPagedIterable;
import com.example.kvtag.DTO.KVTagDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.kvtag.models.KVTag;
import com.example.kvtag.repositories.KVTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class KVTagService {
    @Value("${spring.data.cosmos.database}")
    private String cosmosDatabase;

    private final CosmosClientBuilder cosmosClientBuilder;
    private final KVTagRepository kvTagRepository;

    public Page<KVTag> getAll(Pageable pageable){
        return kvTagRepository.findAll(pageable);
    }

    public KVTag get(String key) {
        return kvTagRepository.findById(key).orElse(null);
    }

    public KVTag getByName(String name) {
        return kvTagRepository.findByName(name).orElse(null);
    }

    public KVTag getByValues(List<String> values) {
        return kvTagRepository.findByValue(values).orElse(null);
    }

    public void delete(String key) {
        kvTagRepository.deleteById(key);
    }

    public void batchDelete(List<String> ids){
        kvTagRepository.deleteAllById(ids);
    }

    public KVTag create(KVTagDTO kvTagDTO) {
        KVTag kvTag = new KVTag();
        kvTag.setName(kvTagDTO.getName());
        kvTag.setValues(kvTagDTO.getValues());
        kvTag.setIsActive(kvTagDTO.getIsActive());

        kvTag.setId(UUID.randomUUID().toString());
        kvTag.setCreatedBy(kvTagDTO.getUpdateBy());
        kvTag.setLastModifiedBy(kvTagDTO.getUpdateBy());

        Long currentTime = System.currentTimeMillis();
        kvTag.setCreatedDate(currentTime);
        kvTag.setLastModifiedDate(currentTime);

        return kvTagRepository.save(kvTag);
    }

    public KVTag update(KVTag kvTag) {
        return kvTagRepository.save(kvTag);
    }
}
