package com.betrybe.agrix.service.fertilizer;

import com.betrybe.agrix.dto.FertilizerCreationDto;
import com.betrybe.agrix.exception.NotFoundException;
import com.betrybe.agrix.model.entity.Fertilizer;
import java.util.List;

/**
 * Interface for fertilizer service class.
 */
public interface FertilizerServiceInterface {
  
  List<Fertilizer> getAll();
  
  Fertilizer getById(int id) throws NotFoundException;

  Fertilizer save(FertilizerCreationDto fertilizerBody);

  void associateCrop(int fertilizerId, int cropId) throws NotFoundException;

}
