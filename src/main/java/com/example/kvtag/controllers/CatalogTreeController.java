package com.example.kvtag.controllers;

import ai.qworks.dao.nontransaction.CatalogTree;
import com.example.kvtag.DTO.CatalogSearchDTO;
import com.example.kvtag.services.CatalogTreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/catalog")
@RequiredArgsConstructor
public class CatalogTreeController {
    private final CatalogTreeService catalogTreeService;

    @PostMapping("/global_search")
    public ResponseEntity<List<CatalogTree>> globalSearch(@RequestBody CatalogSearchDTO catalogSearchDTO) {
        // Currently we are getting the CatalogTree data from the body for testing purpose. While doing the integration, please remove this, just able to send the query String only
        return ResponseEntity.ok(catalogTreeService.globalSearch(catalogSearchDTO.filter, catalogSearchDTO.roots));
    }
}
