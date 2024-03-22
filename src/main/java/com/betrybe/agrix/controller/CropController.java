package com.betrybe.agrix.controller;

import com.betrybe.agrix.dto.CropDto;
import com.betrybe.agrix.dto.FertilizerDto;
import com.betrybe.agrix.exception.NotFoundException;
import com.betrybe.agrix.model.entity.Crop;
import com.betrybe.agrix.service.crop.CropServiceInterface;
import com.betrybe.agrix.service.fertilizer.FertilizerServiceInterface;
import com.betrybe.agrix.util.ModelDtoConverter;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Crop controller.
 */
@RestController
@RequestMapping(value = "/crops")
public class CropController {
  @Autowired
  private CropServiceInterface cropService;
  @Autowired
  private FertilizerServiceInterface fertilizerService;
  
  /**
   * Get all crops.
   */
  @GetMapping
  public ResponseEntity<List<CropDto>> getAll() {
    List<Crop> crops = cropService.getAll();
    List<CropDto> response = ModelDtoConverter.convertCropsListToDtoList(crops);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
  
  /**
   * Get crop by id.
   */
  @GetMapping(value = "/{id}")
  public ResponseEntity<CropDto> getById(@PathVariable int id) throws NotFoundException {
    Crop crop = cropService.getById(id);
    CropDto dto = new CropDto(id, crop.getName(), crop.getPlantedArea(), crop.getFarm().getId(),
        crop.getPlantedDate(), crop.getHarvestDate());
    return ResponseEntity.status(HttpStatus.OK).body(dto);
  }
  
  /**
   * Search crops.
   */
  @GetMapping(value = "/search")
  public ResponseEntity<List<CropDto>> search(
      @RequestParam(name = "start", required = true) LocalDate initialHarvestDate,
      @RequestParam(name = "end", required = true) LocalDate finalHarvestDate) {
    List<Crop> crops = cropService.searchByDates(initialHarvestDate, finalHarvestDate);
    List<CropDto> response = ModelDtoConverter.convertCropsListToDtoList(crops);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
  
  /**
   * Get fertilizers.
   */
  @GetMapping(value = "/{cropId}/fertilizers")
  public ResponseEntity<List<FertilizerDto>> getFertilizers(@PathVariable int cropId)
      throws NotFoundException {
    Crop crop = cropService.getById(cropId);
    List<FertilizerDto> response = ModelDtoConverter
        .convertFertilizersListToDtoList(crop.getFertilizers());
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  /**
   * Associate fertilizer.
   */
  @PostMapping(value = "/{cropId}/fertilizers/{fertilizerId}")
  public ResponseEntity<String> associateFertilizer(@PathVariable int cropId,
      @PathVariable int fertilizerId) throws NotFoundException {
    fertilizerService.associateCrop(fertilizerId, cropId);
    String response = "Fertilizante e plantação associados com sucesso!";
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
}
