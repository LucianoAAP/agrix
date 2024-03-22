package com.betrybe.agrix.service.farm;

import com.betrybe.agrix.dto.FarmCreationDto;
import com.betrybe.agrix.exception.NotFoundException;
import com.betrybe.agrix.model.entity.Farm;
import com.betrybe.agrix.model.repository.FarmRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Farm service.
 */
@Service
public class FarmService implements FarmServiceInterface {
  @Autowired
  private FarmRepository farmRepository;
  
  @Override
  public List<Farm> getAll() {
    return farmRepository.findAll();
  }
  
  @Override
  public Farm getById(int id) throws NotFoundException {
    Optional<Farm> farm = farmRepository.findById(id);
    if (farm.isEmpty()) {
      throw new NotFoundException("Fazenda não encontrada!");
    }
    return farm.get();
  }
  
  @Override
  public Farm save(FarmCreationDto farmBody) {
    Farm farm = new Farm(farmBody.name(), farmBody.size());
    return farmRepository.save(farm);
  }
}
