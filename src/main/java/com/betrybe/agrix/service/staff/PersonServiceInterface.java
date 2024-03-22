package com.betrybe.agrix.service.staff;

import com.betrybe.agrix.model.entity.Person;

/**
 * Interface for person service class.
 */
public interface PersonServiceInterface {

  Person getPersonById(Long id);

  Person getPersonByUsername(String username);

  Person create(Person person);

}
