package com.betrybe.agrix.dto;

import java.time.LocalDate;

/**
 * Record representing a crop.
 */
public record CropDto(int id, String name, Double plantedArea, int farmId,
    LocalDate plantedDate, LocalDate harvestDate) {

}
