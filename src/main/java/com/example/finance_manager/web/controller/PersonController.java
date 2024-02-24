package com.example.finance_manager.web.controller;

import com.example.finance_manager.model.Person;
import com.example.finance_manager.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/person")
public class PersonController {

  private PersonService personService;

  @GetMapping
  public void createPerson(@RequestBody Person person) {

    personService.createPerson(person);
  }
}
