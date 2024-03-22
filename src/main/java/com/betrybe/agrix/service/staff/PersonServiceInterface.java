package com.betrybe.agrix.service.staff;

import com.betrybe.agrix.model.entity.Person;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Interface for person service class.
 */
public interface PersonServiceInterface {

  Person getPersonById(Long id);

  Person getPersonByUsername(String username);

  Person create(Person person);

  UserDetails loadUserByUsername(String subject);

}
