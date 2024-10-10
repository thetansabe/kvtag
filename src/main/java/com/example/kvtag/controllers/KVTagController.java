package com.example.kvtag.controllers;

import com.example.kvtag.models.KVTag;
import com.example.kvtag.services.KVTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

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

    @GetMapping("/name/{name}")
    public ResponseEntity<KVTag> getByName(@PathVariable String name) {
        return ResponseEntity.ok(kvTagService.getByName(name));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(kvTagService.getAll(pageable));
    }
}
