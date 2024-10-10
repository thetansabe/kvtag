package com.example.kvtag.services;

import com.example.kvtag.models.KVTag;
import com.example.kvtag.repositories.KVTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KVTagService {
    private final KVTagRepository kvTagRepository;

    public void create(KVTag kvTag) {
        kvTagRepository.save(kvTag);
    }

    public KVTag get(String key) {
        return kvTagRepository.findById(key).orElse(null);
    }
}
