package com.example.kvtag.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.kvtag.models.KVTag;
import com.example.kvtag.repositories.KVTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KVTagService {
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

    public void delete(String key) {
        kvTagRepository.deleteById(key);
    }

    public void deleteByName(String name) {
        kvTagRepository.findByName(name).ifPresent(kvTag -> kvTagRepository.deleteById(kvTag.getId()));
    }

    // create
    // nen return entity?
    public void create(KVTag kvTag) {
        kvTagRepository.save(kvTag);
    }
    // update
    // batch update
    // batch delete
}
