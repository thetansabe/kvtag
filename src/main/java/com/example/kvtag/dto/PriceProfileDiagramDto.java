package com.example.kvtag.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PriceProfileDiagramDto {

    private String id;

    private String name;

    private JsonNode edges;

    private JsonNode nodes;

    private Boolean isActive;

}
