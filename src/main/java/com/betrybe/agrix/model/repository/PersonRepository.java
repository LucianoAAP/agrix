package com.betrybe.agrix.model.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.betrybe.agrix.model.entity.Person;

/**
 * Person JPA repository.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

  Optional<Person> findByUsername(String username);
}
