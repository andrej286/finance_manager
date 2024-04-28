package com.example.finance_manager.web.controller;

import com.example.finance_manager.model.Income;
import com.example.finance_manager.service.IncomeService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api/incomes")
public class IncomeController {

  private IncomeService incomeService;

  @GetMapping
  public List<Income> findIncomes(@AuthenticationPrincipal(expression = "attributes.get('email')") String email) {

    // TODO: 4/29/2024: configure fetching of the incomes through the email.

    return incomeService.fetchIncomes();
  }

  @PostMapping
  public void createIncome(@RequestBody Income income) {

    incomeService.createIncome(income);
  }

  @DeleteMapping("/{id}")
  public void deleteIncome(@PathVariable Long id) {

    incomeService.deleteIncome(id);
  }
}
