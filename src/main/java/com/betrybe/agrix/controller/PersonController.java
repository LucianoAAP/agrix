package com.betrybe.agrix.controller;

import com.betrybe.agrix.dto.PersonCreationDto;
import com.betrybe.agrix.dto.PersonDto;
import com.betrybe.agrix.model.entity.Person;
import com.betrybe.agrix.service.staff.PersonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Person controller.
 */
@RestController
@RequestMapping(value = "/persons")
public class PersonController {
  @Autowired
  private PersonServiceInterface personService;

  /**
   * Saves a person.
   */
  @PostMapping
  public ResponseEntity<PersonDto> save(@RequestBody PersonCreationDto personBody) {
    Person person = new Person(personBody);
    person = personService.create(person);
    PersonDto response = new PersonDto(person.getId(), person.getUsername(), person.getRole());
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
}
