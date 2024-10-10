package com.example.kvtag.controllers;

import com.example.kvtag.models.KVTag;
import com.example.kvtag.services.KVTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/kvtag")
@RequiredArgsConstructor
public class KVTagController {
    private final KVTagService kvTagService;

    @PostMapping
    public ResponseEntity<Boolean> create(@RequestBody KVTag kvTag) {
        kvTagService.create(kvTag);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/{key}")
    public ResponseEntity<KVTag> get(@PathVariable String key) {
        return ResponseEntity.ok(kvTagService.get(key));
    }
}
