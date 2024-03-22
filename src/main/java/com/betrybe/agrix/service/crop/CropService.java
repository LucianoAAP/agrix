package com.betrybe.agrix.service.crop;

import com.betrybe.agrix.dto.CropCreationDto;
import com.betrybe.agrix.exception.NotFoundException;
import com.betrybe.agrix.model.entity.Crop;
import com.betrybe.agrix.model.entity.Farm;
import com.betrybe.agrix.model.repository.CropRepository;
import com.betrybe.agrix.service.farm.FarmServiceInterface;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Crop service.
 */
@Service
public class CropService implements CropServiceInterface {
  @Autowired
  private CropRepository cropRepository;
  @Autowired
  private FarmServiceInterface farmService;
  
  @Override
  public List<Crop> getAll() {
    return cropRepository.findAll();
  }
  
  @Override
  public Crop getById(int id) throws NotFoundException {
    Optional<Crop> farm = cropRepository.findById(id);
    if (farm.isEmpty()) {
      throw new NotFoundException("Plantação não encontrada!");
    }
    return farm.get();
  }
  
  @Override
  public Crop save(int farmId, CropCreationDto cropBody) throws NotFoundException {
    Farm farm = farmService.getById(farmId);
    Crop crop = new Crop(cropBody.name(), cropBody.plantedArea(), farm,
        cropBody.plantedDate(), cropBody.harvestDate());
    return cropRepository.save(crop);
  }
  
  @Override
  public List<Crop> searchByDates(LocalDate initialHarvestDate, LocalDate finalHarvestDate) {
    return cropRepository.findByHarvestDateBetween(initialHarvestDate, finalHarvestDate);
  }
}
