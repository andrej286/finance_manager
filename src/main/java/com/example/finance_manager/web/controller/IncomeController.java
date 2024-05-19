package com.example.finance_manager.web.controller;

import com.example.finance_manager.model.Income;
import com.example.finance_manager.service.IncomeService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api/incomes")
public class IncomeController {

  private IncomeService incomeService;

  @GetMapping
  public List<Income> findIncomes(@AuthenticationPrincipal(expression = "attributes.get('email')") String email) {
    return incomeService.fetchIncomes(email);
  }

  @PostMapping
  public void createIncome(@AuthenticationPrincipal(expression = "attributes.get('email')") String email, @RequestBody Income income) {
    incomeService.createIncome(income, email);
  }

  @DeleteMapping("/{id}")
  public void deleteIncome(@AuthenticationPrincipal(expression = "attributes.get('email')") String email, @PathVariable Long id) {
    incomeService.deleteIncome(id, email);
  }

  @PutMapping("/{id}")
  public void updateIncome(@AuthenticationPrincipal(expression = "attributes.get('email')") String email, @PathVariable Long id, @RequestBody Income updatedIncome) {
    incomeService.updateIncome(id, updatedIncome, email);
  }
}

