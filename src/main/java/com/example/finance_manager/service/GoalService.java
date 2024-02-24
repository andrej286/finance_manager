package com.example.finance_manager.service;

import com.example.finance_manager.model.Goal;
import com.example.finance_manager.repository.GoalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GoalService {

  private GoalRepository goalRepository;

  public void createGoal(Goal goal) {

    goalRepository.save(goal);
  }

  public void deleteGoal(Long id) {

    goalRepository.deleteById(id);
  }

  public List<Goal> fetchGoals() {

    return goalRepository.findAll();
  }
}
