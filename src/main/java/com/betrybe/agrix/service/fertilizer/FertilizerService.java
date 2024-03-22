package com.betrybe.agrix.service.fertilizer;

import com.betrybe.agrix.dto.FertilizerCreationDto;
import com.betrybe.agrix.exception.NotFoundException;
import com.betrybe.agrix.model.entity.Crop;
import com.betrybe.agrix.model.entity.Fertilizer;
import com.betrybe.agrix.model.repository.FertilizerRepository;
import com.betrybe.agrix.service.crop.CropServiceInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Fertilizer service.
 */
@Service
public class FertilizerService implements FertilizerServiceInterface {
  @Autowired
  private FertilizerRepository fertilizerRepository;
  @Autowired
  private CropServiceInterface cropService;
  
  /**
   * Get all fertilizers.
   */
  @Override
  public List<Fertilizer> getAll() {
    return fertilizerRepository.findAll();
  }
  
  /**
   * Get fertilizer by id.
   */
  @Override
  public Fertilizer getById(int id) throws NotFoundException {
    Optional<Fertilizer> fertilizer = fertilizerRepository.findById(id);
    if (fertilizer.isEmpty()) {
      throw new NotFoundException("Fertilizante não encontrado!");
    }
    return fertilizer.get();
  }
  
  /**
   * Save fertilizer.
   */
  @Override
  public Fertilizer save(FertilizerCreationDto fertilizerBody) {
    Fertilizer fertilizer = new Fertilizer(
        fertilizerBody.name(), fertilizerBody.brand(), fertilizerBody.composition());
    return fertilizerRepository.save(fertilizer);
  }
  
  /**
   * Associate crop.
   */
  @Override
  public void associateCrop(int fertilizerId, int cropId) throws NotFoundException {
    Fertilizer fertilizer = getById(fertilizerId);
    Crop crop = cropService.getById(cropId);
    fertilizer.getCrops().add(crop);
    fertilizerRepository.save(fertilizer);
  }
}
