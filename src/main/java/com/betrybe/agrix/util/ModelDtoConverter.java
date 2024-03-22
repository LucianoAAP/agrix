package com.betrybe.agrix.util;

import com.betrybe.agrix.dto.CropDto;
import com.betrybe.agrix.dto.FertilizerDto;
import com.betrybe.agrix.model.entity.Crop;
import com.betrybe.agrix.model.entity.Fertilizer;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class to convert between model and dto.
 */
public class ModelDtoConverter {

  /**
   * Converts a list of crops to dto list.
   */
  public static List<CropDto> convertCropsListToDtoList(List<Crop> crops) {
    List<CropDto> response = crops.stream().map(crop -> {
      int farmId = crop.getFarm().getId();
      return new CropDto(crop.getId(), crop.getName(), crop.getPlantedArea(), farmId,
          crop.getPlantedDate(), crop.getHarvestDate());
    }).collect(Collectors.toList());
    return response;
  }
  
  /**
   * Converts a list of crops to dto list.
   */
  public static List<FertilizerDto> convertFertilizersListToDtoList(List<Fertilizer> fertilizers) {
    List<FertilizerDto> response = fertilizers.stream().map(fertilizer -> {
      return new FertilizerDto(fertilizer.getId(), fertilizer.getName(),
          fertilizer.getBrand(), fertilizer.getComposition());
    }).collect(Collectors.toList());
    return response;
  }
  
}
