package com.example.finance_manager.web.controller;

import com.example.finance_manager.model.Cost;
import com.example.finance_manager.service.CostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api/costs")
public class CostController {

  private CostService costService;

  @GetMapping
  public List<Cost> findGoals() {

    return costService.fetchCosts();
  }

  @PostMapping
  public void createGoal(@RequestBody Cost cost) {

    costService.createCost(cost);
  }

  @DeleteMapping("/{id}")
  public void deleteGoal(@PathVariable Long id) {

    costService.deleteCost(id);
  }
}
