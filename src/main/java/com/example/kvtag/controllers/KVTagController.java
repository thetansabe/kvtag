package com.example.kvtag.controllers;

import com.example.kvtag.dto.KVTagDTO;
import com.example.kvtag.entity.KVTag;
import com.example.kvtag.services.KVTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/v1/kvtag")
@RequiredArgsConstructor
public class KVTagController {
    private final KVTagService kvTagService;

    @PostMapping
    public ResponseEntity<KVTag> create(@RequestBody KVTagDTO kvTag) {
        return ResponseEntity.ok(kvTagService.create(kvTag));
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

    @PostMapping("/values")
    public ResponseEntity<List<KVTag>> getByValues(@RequestBody List<String> values) {
        return ResponseEntity.ok(kvTagService.getByValues(values));
    }

    @PutMapping()
    public ResponseEntity<KVTag> update(@RequestBody KVTag kvTag) {
        return ResponseEntity.ok(kvTagService.update(kvTag));
    }

    @DeleteMapping("/{key}")
    public ResponseEntity<?> delete(@PathVariable String key) {
        kvTagService.delete(key);
        return ResponseEntity.ok("KVTag deleted successfully");
    }

    @DeleteMapping("/batch")
    public ResponseEntity<?> batchDelete(@RequestBody List<String> ids) {
        kvTagService.batchDelete(ids);
        return ResponseEntity.ok("KVTags deleted successfully");
    }
}
