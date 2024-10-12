package com.example.kvtag.controllers;

import com.example.kvtag.dto.PriceProfileDiagramDto;
import com.example.kvtag.dto.response.ApiResponse;
import com.example.kvtag.services.IPriceProfileDiagramService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public ResponseEntity<ApiResponse<PriceProfileDiagramDto>> getAll(@RequestParam(defaultValue = "0") int page,
                                                                      @RequestParam(defaultValue = "10") int size) {
        Page<PriceProfileDiagramDto> diagrams = priceProfileDiagramService.getAll(
                PageRequest.of(page, size)
        );

        ApiResponse<PriceProfileDiagramDto> response = new ApiResponse<>(
                diagrams.getTotalElements(),
                size,
                page,
                diagrams.getTotalPages(),
                diagrams.getContent()
        );

        return ResponseEntity.ok(response);
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
