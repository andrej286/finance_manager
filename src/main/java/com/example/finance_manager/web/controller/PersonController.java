package com.example.finance_manager.web.controller;

import com.example.finance_manager.model.Person;
import com.example.finance_manager.model.dtos.PersonInfo;
import com.example.finance_manager.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api/person")
public class PersonController {

  private PersonService personService;

  @PostMapping("/check-in")
  public Person handleCheckIn(
          @AuthenticationPrincipal(expression = "attributes.get('email')") String email,
          @AuthenticationPrincipal(expression = "attributes.get('name')") String name
  ) {

    return personService.createPersonIfNotExist(email, name);
  }

  @GetMapping("/info")
  public PersonInfo fetchPersonInfo(
    @AuthenticationPrincipal(expression = "attributes.get('email')") String email,
    @AuthenticationPrincipal(expression = "attributes.get('name')") String name
  ) {

    return new PersonInfo(name, email);
  }
}
