package com.example.finance_manager.web.controller;

import com.example.finance_manager.model.Goal;
import com.example.finance_manager.service.GoalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api/goals")
public class GoalController {

  private GoalService goalService;

  @GetMapping
  public List<Goal> findGoals() {

    return goalService.fetchGoals();
  }

  @PostMapping
  public void createGoal(@RequestBody Goal goal) {

    goalService.createGoal(goal);
  }

  @DeleteMapping("/{id}")
  public void deleteGoal(@PathVariable Long id) {

    goalService.deleteGoal(id);
  }

  @PutMapping("/{id}")
  public void updateGoal(@PathVariable Long id, @RequestBody Goal updatedGoal) {
    goalService.updateGoal(id, updatedGoal);
  }
}
