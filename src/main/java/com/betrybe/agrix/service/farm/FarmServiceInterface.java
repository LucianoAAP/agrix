package com.betrybe.agrix.service.farm;

import com.betrybe.agrix.dto.FarmCreationDto;
import com.betrybe.agrix.exception.NotFoundException;
import com.betrybe.agrix.model.entity.Farm;
import java.util.List;

/**
 * Interface for farm service class.
 */
public interface FarmServiceInterface {

  List<Farm> getAll();

  Farm getById(int id) throws NotFoundException;
  
  Farm save(FarmCreationDto farmBody);

}
