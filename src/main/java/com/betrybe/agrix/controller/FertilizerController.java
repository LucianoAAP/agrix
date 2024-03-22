package com.betrybe.agrix.controller;

import com.betrybe.agrix.dto.FertilizerCreationDto;
import com.betrybe.agrix.dto.FertilizerDto;
import com.betrybe.agrix.exception.NotFoundException;
import com.betrybe.agrix.model.entity.Fertilizer;
import com.betrybe.agrix.service.fertilizer.FertilizerServiceInterface;
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
 * Fertilizer controller.
 */
@RestController
@RequestMapping(value = "/fertilizers")
public class FertilizerController {
  @Autowired
  private FertilizerServiceInterface fertilizerService;
  
  /**
   * Get all fertilizers.
   */
  @GetMapping
  public ResponseEntity<List<FertilizerDto>> getAll() {
    List<Fertilizer> fertilizers = fertilizerService.getAll();
    List<FertilizerDto> response = ModelDtoConverter.convertFertilizersListToDtoList(fertilizers);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
  
  /**
   * Get fertilizer by id.
   */
  @GetMapping(value = "/{id}")
  public ResponseEntity<FertilizerDto> getById(@PathVariable int id) throws NotFoundException {
    Fertilizer fertilizer = fertilizerService.getById(id);
    FertilizerDto response = new FertilizerDto(fertilizer.getId(), fertilizer.getName(),
        fertilizer.getBrand(), fertilizer.getComposition());
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
  
  /**
   * Save fertilizer.
   */
  @PostMapping
  public ResponseEntity<FertilizerDto> save(@RequestBody FertilizerCreationDto fertilizerBody) {
    Fertilizer fertilizer = fertilizerService.save(fertilizerBody);
    FertilizerDto response = new FertilizerDto(fertilizer.getId(), fertilizer.getName(),
        fertilizer.getBrand(), fertilizer.getComposition());
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
}
