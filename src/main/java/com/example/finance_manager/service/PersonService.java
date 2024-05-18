package com.example.finance_manager.service;

import com.example.finance_manager.model.Person;
import com.example.finance_manager.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {

  private PersonRepository personRepository;

  public void createPerson(Person person) {

    personRepository.save(person);
  }

  public Person createPersonIfNotExist(String email, String name) {
    return personRepository.findByEmail(email).orElseGet(() -> {
      Person person = new Person();
      person.setEmail(email);
      person.setName(name);
      person.setAssets(List.of());
      person.setGoals(List.of());
      person.setIncomes(List.of());
      person.setCosts(List.of());
      return personRepository.save(person);
    });
  }
}
