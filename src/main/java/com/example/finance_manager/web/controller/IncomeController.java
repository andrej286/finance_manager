package com.example.finance_manager.web.controller;

import com.example.finance_manager.model.Income;
import com.example.finance_manager.service.IncomeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api/incomes")
public class IncomeController {

  private IncomeService incomeService;

  @GetMapping
  public List<Income> findIncomes() {

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
