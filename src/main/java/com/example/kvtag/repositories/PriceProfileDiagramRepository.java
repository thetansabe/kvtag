package com.example.kvtag.repositories;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.example.kvtag.entity.PriceProfileDiagram;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceProfileDiagramRepository extends CosmosRepository<PriceProfileDiagram, String> {
}
