package com.example.kvtag.services.impl;

import com.example.kvtag.dto.PriceProfileDiagramDto;
import com.example.kvtag.exception.CustomException.EntityNotFoundException;
import com.example.kvtag.entity.PriceProfileDiagram;
import com.example.kvtag.repositories.PriceProfileDiagramRepository;
import com.example.kvtag.services.IPriceProfileDiagramService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PriceProfileDiagramService implements IPriceProfileDiagramService {

    private final PriceProfileDiagramRepository repository;

    @Override
    public PriceProfileDiagramDto create(PriceProfileDiagramDto dto) {
        PriceProfileDiagram diagram = convertToCreateEntity(dto);
        PriceProfileDiagram createdDiagram = repository.save(diagram);
        return convertToDto(createdDiagram);
    }

    @Override
    public Page<PriceProfileDiagramDto> getAll(Pageable pageable) {
        Page<PriceProfileDiagram> diagrams = repository.findAll(pageable);
        return diagrams.map(this::convertToDto);
    }

    @Override
    public PriceProfileDiagramDto getById(String id) {
        return repository.findById(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new EntityNotFoundException("PriceProfileDiagram not found with id: " + id));
    }

    @Override
    public PriceProfileDiagramDto update(String id, PriceProfileDiagramDto dto) {
        PriceProfileDiagram existingDiagram = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PriceProfileDiagram not found with id: " + id));
        existingDiagram.setName(dto.getName());
        existingDiagram.setEdges(dto.getEdges());
        existingDiagram.setNodes(dto.getNodes());
        existingDiagram.setIsActive(dto.getIsActive());
        PriceProfileDiagram updatedDiagram = repository.save(existingDiagram);
        return convertToDto(updatedDiagram);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    private PriceProfileDiagramDto convertToDto(PriceProfileDiagram diagram) {
        return PriceProfileDiagramDto.builder()
                .id(diagram.getId())
                .name(diagram.getName())
                .edges(diagram.getEdges())
                .nodes(diagram.getNodes())
                .isActive(diagram.getIsActive())
                .build();
    }

    private PriceProfileDiagram convertToCreateEntity(PriceProfileDiagramDto dto) {
        PriceProfileDiagram diagram = new PriceProfileDiagram();
        diagram.setName(dto.getName());
        diagram.setEdges(dto.getEdges());
        diagram.setNodes(dto.getNodes());
        diagram.setIsActive(dto.getIsActive());

        diagram.setId(UUID.randomUUID().toString());

        Long currentTime = System.currentTimeMillis();
        diagram.setCreatedDate(currentTime);
        diagram.setLastModifiedDate(currentTime);

        return diagram;
    }

    private List<PriceProfileDiagramDto> convertToDtoList(Iterable<PriceProfileDiagram> diagrams) {
        List<PriceProfileDiagramDto> dtoList = new ArrayList<>();
        for (PriceProfileDiagram diagram : diagrams) {
            dtoList.add(convertToDto(diagram));
        }
        return dtoList;
    }
}
