package com.example.finance_manager.web.controller;

import com.example.finance_manager.model.Cost;
import com.example.finance_manager.service.CostService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api/costs")
public class CostController {

  private CostService costService;

  @GetMapping
  public List<Cost> findCosts(@AuthenticationPrincipal(expression = "attributes.get('email')") String email) {
    return costService.fetchCosts(email);
  }

  @PostMapping
  public void createCost(@AuthenticationPrincipal(expression = "attributes.get('email')") String email, @RequestBody Cost cost) {
    costService.createCost(cost, email);
  }

  @DeleteMapping("/{id}")
  public void deleteCost(@AuthenticationPrincipal(expression = "attributes.get('email')") String email, @PathVariable Long id) {
    costService.deleteCost(id, email);
  }

  @PutMapping("/{id}")
  public void updateCost(@AuthenticationPrincipal(expression = "attributes.get('email')") String email, @PathVariable Long id, @RequestBody Cost updatedCost) {
    costService.updateCost(id, updatedCost, email);
  }
}
