package com.betrybe.agrix.controller;

import com.betrybe.agrix.dto.CropCreationDto;
import com.betrybe.agrix.dto.CropDto;
import com.betrybe.agrix.dto.FarmCreationDto;
import com.betrybe.agrix.exception.NotFoundException;
import com.betrybe.agrix.model.entity.Crop;
import com.betrybe.agrix.model.entity.Farm;
import com.betrybe.agrix.service.crop.CropServiceInterface;
import com.betrybe.agrix.service.farm.FarmServiceInterface;
import com.betrybe.agrix.util.ModelDtoConverter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Farm controller.
 */
@RestController
@RequestMapping(value = "/farms")
public class FarmController {
  @Autowired
  private FarmServiceInterface farmService;
  @Autowired
  private CropServiceInterface cropService;
  
  @GetMapping
  public ResponseEntity<List<Farm>> getAll() {
    List<Farm> farms = farmService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(farms);
  }
  
  @GetMapping(value = "/{id}")
  public ResponseEntity<Farm> getById(@PathVariable int id) throws NotFoundException {
    Farm farm = farmService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(farm);
  }
  
  @PostMapping
  public ResponseEntity<Farm> save(@RequestBody FarmCreationDto farmBody) {
    Farm farm = farmService.save(farmBody);
    return ResponseEntity.status(HttpStatus.CREATED).body(farm);
  }
  
  /**
   * Get crops.
   */
  @GetMapping(value = "/{farmId}/crops")
  public ResponseEntity<List<CropDto>> getCrops(@PathVariable int farmId) throws NotFoundException {
    Farm farm = farmService.getById(farmId);
    List<CropDto> response = ModelDtoConverter.convertCropsListToDtoList(farm.getCrops());
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
  
  /**
   * Save crops.
   */
  @PostMapping(value = "/{farmId}/crops")
  public ResponseEntity<CropDto> saveCrops(@PathVariable int farmId,
      @RequestBody CropCreationDto cropBody) throws NotFoundException {
    Crop crop = cropService.save(farmId, cropBody);
    CropDto response = new CropDto(crop.getId(), crop.getName(), crop.getPlantedArea(), farmId,
        crop.getPlantedDate(), crop.getHarvestDate());
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
}
