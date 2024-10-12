package com.example.kvtag.services;

import com.example.kvtag.dto.PriceProfileDiagramDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * The interface Price profile diagram service.
 */
public interface IPriceProfileDiagramService {

    /**
     * Create price profile diagram dto.
     *
     * @param dto the dto
     * @return the price profile diagram dto
     */
    PriceProfileDiagramDto create(PriceProfileDiagramDto dto);

    /**
     * Gets all.
     *
     * @param pageable the pageable
     * @return the all
     */
    Page<PriceProfileDiagramDto> getAll(Pageable pageable);

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    PriceProfileDiagramDto getById(String id);

    /**
     * Update price profile diagram dto.
     *
     * @param id  the id
     * @param dto the dto
     * @return the price profile diagram dto
     */
    PriceProfileDiagramDto update(String id, PriceProfileDiagramDto dto);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(String id);
}
