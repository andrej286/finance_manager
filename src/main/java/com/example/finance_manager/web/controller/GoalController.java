package com.example.finance_manager.web.controller;

import com.example.finance_manager.model.Goal;
import com.example.finance_manager.service.GoalService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api/goals")
public class GoalController {

  private GoalService goalService;

  @GetMapping
  public List<Goal> findGoals(@AuthenticationPrincipal(expression = "attributes.get('email')") String email) {
    return goalService.fetchGoals(email);
  }

  @PostMapping
  public void createGoal(@AuthenticationPrincipal(expression = "attributes.get('email')") String email, @RequestBody Goal goal) {
    goalService.createGoal(goal, email);
  }

  @DeleteMapping("/{id}")
  public void deleteGoal(@PathVariable Long id, @AuthenticationPrincipal(expression = "attributes.get('email')") String email) {
    goalService.deleteGoal(id, email);
  }

  @PutMapping("/{id}")
  public void updateGoal(@PathVariable Long id, @RequestBody Goal updatedGoal, @AuthenticationPrincipal(expression = "attributes.get('email')") String email) {
    goalService.updateGoal(id, updatedGoal, email);
  }
}
