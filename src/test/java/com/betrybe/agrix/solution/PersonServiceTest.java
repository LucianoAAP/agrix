package com.betrybe.agrix.solution;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.exception.PersonNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.PersonRepository;
import com.betrybe.agrix.ebytr.staff.security.Role;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class PersonServiceTest {
  @Autowired
  private PersonService personService;
  @MockBean
  private PersonRepository personRepository;
  
  @Test
  @DisplayName("GetPersonById deve lançar exceção quando nada for encontrado")
  void testGetPersonByIdNotFound() {
    Optional<Person> optionalPersonMock = Optional.empty();
    Mockito.when(personRepository.findById(237L)).thenReturn(optionalPersonMock);
    assertThrows(PersonNotFoundException.class, () -> personService.getPersonById(237L));
    Mockito.verify(personRepository).findById(237L);
  }
  
  @Test
  @DisplayName("GetPersonById Deve retornar o resultado correto")
  void testGetPersonByIdResult() {
    Person personMock = new Person();
    personMock.setId(1L);
    personMock.setUsername("Fulano");
    personMock.setPassword("xablau");
    personMock.setRole(Role.USER);
    
    Optional<Person> optionalPersonMock = Optional.of(personMock);
    Mockito.when(personRepository.findById(1L)).thenReturn(optionalPersonMock);
    
    Person person = personService.getPersonById(1L);
    
    assertEquals(personMock.getId(), person.getId());
    assertEquals(personMock.getUsername(), person.getUsername());
    assertEquals(personMock.getPassword(), person.getPassword());
    assertEquals(personMock.getRole(), person.getRole());
    Mockito.verify(personRepository).findById(1L);
  }
  
  @Test
  @DisplayName("GetPersonByUserName deve lançar exceção quando nada for encontrado")
  void testGetPersonByUserNameNotFound() {
    Optional<Person> optionalPersonMock = Optional.empty();
    Mockito.when(personRepository.findByUsername("Fulano")).thenReturn(optionalPersonMock);
    assertThrows(PersonNotFoundException.class, () -> personService.getPersonByUsername("Fulano"));
    Mockito.verify(personRepository).findByUsername("Fulano");
  }
  
  @Test
  @DisplayName("GetPersonByUserName deve retornar o resultado correto")
  void testGetPersonByUserNameResult() {
    Person personMock = new Person();
    personMock.setId(1L);
    personMock.setUsername("Fulano");
    personMock.setPassword("xablau");
    personMock.setRole(Role.USER);
    
    Optional<Person> optionalPersonMock = Optional.of(personMock);
    Mockito.when(personRepository.findByUsername("Fulano")).thenReturn(optionalPersonMock);
    
    Person person = personService.getPersonByUsername("Fulano");
    
    assertEquals(personMock.getId(), person.getId());
    assertEquals(personMock.getUsername(), person.getUsername());
    assertEquals(personMock.getPassword(), person.getPassword());
    assertEquals(personMock.getRole(), person.getRole());
    Mockito.verify(personRepository).findByUsername("Fulano");
  }
  
  @Test
  @DisplayName("Create deve retornar o resultado correto")
  void testCreate() {
    Person personRequest = new Person();
    personRequest.setUsername("Fulano");
    personRequest.setPassword("xablau");
    personRequest.setRole(Role.USER);
    
    Person personMock = new Person();
    personMock.setId(1L);
    personMock.setUsername("Fulano");
    personMock.setPassword("xablau");
    personMock.setRole(Role.USER);
    
    Mockito.when(personRepository.save(personRequest)).thenReturn(personMock);
    
    Person person = personService.create(personRequest);
    
    assertEquals(personMock.getId(), person.getId());
    assertEquals(personMock.getUsername(), person.getUsername());
    assertEquals(personMock.getPassword(), person.getPassword());
    assertEquals(personMock.getRole(), person.getRole());
    Mockito.verify(personRepository).save(personRequest);
  }
}
