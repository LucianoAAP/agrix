package com.betrybe.agrix.model.repository;

import com.betrybe.agrix.model.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Farm repository.
 */
@Repository
public interface FarmRepository extends JpaRepository<Farm, Integer> {

}
