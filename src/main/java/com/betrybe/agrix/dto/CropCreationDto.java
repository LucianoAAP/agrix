package com.betrybe.agrix.dto;

import java.time.LocalDate;

/**
 * Record representing crop creation.
 */
public record CropCreationDto(String name, Double plantedArea,
    LocalDate plantedDate, LocalDate harvestDate) {

}
