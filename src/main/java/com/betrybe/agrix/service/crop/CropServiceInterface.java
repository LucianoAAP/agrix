package com.betrybe.agrix.service.crop;

import com.betrybe.agrix.dto.CropCreationDto;
import com.betrybe.agrix.exception.NotFoundException;
import com.betrybe.agrix.model.entity.Crop;
import java.time.LocalDate;
import java.util.List;

/**
 * Interface for crop service class.
 */
public interface CropServiceInterface {

  List<Crop> getAll();
  
  Crop getById(int id) throws NotFoundException;
  
  Crop save(int farmId, CropCreationDto cropBody) throws NotFoundException;

  List<Crop> searchByDates(LocalDate initialHarvestDate, LocalDate finalHarvestDate);

}
