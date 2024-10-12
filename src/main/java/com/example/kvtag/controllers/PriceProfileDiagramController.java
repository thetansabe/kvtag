package com.example.kvtag.controllers;

import com.example.kvtag.DTO.PriceProfileDiagramDto;
import com.example.kvtag.services.IPriceProfileDiagramService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/price-profile-diagrams")
@RequiredArgsConstructor
public class PriceProfileDiagramController {

    private final IPriceProfileDiagramService priceProfileDiagramService;

    @PostMapping
    public ResponseEntity<PriceProfileDiagramDto> create(@RequestBody PriceProfileDiagramDto dto) {
        PriceProfileDiagramDto createdDiagram = priceProfileDiagramService.create(dto);
        return ResponseEntity.ok(createdDiagram);
    }

    @GetMapping
    public ResponseEntity<Iterable<PriceProfileDiagramDto>> getAll() {
        Iterable<PriceProfileDiagramDto> diagrams = priceProfileDiagramService.getAll();
        return ResponseEntity.ok(diagrams);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PriceProfileDiagramDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(priceProfileDiagramService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PriceProfileDiagramDto> update(@PathVariable String id, @RequestBody PriceProfileDiagramDto dto) {
        PriceProfileDiagramDto updatedDiagram = priceProfileDiagramService.update(id, dto);
        return ResponseEntity.ok(updatedDiagram);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        priceProfileDiagramService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
