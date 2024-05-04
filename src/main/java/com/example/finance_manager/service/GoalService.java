package com.example.finance_manager.service;

import com.example.finance_manager.model.Goal;
import com.example.finance_manager.repository.GoalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

  public void updateGoal(Long id, Goal updatedGoal) {

    Optional<Goal> existingGoalOptional = goalRepository.findById(id);
    if (existingGoalOptional.isPresent()) {
      Goal existingGoal = existingGoalOptional.get();
      existingGoal.setName(updatedGoal.getName());
      existingGoal.setDescription(updatedGoal.getDescription());
      existingGoal.setAmount(updatedGoal.getAmount());
      existingGoal.setDateOfOccurrence(updatedGoal.getDateOfOccurrence());
      existingGoal.setGoalType(updatedGoal.getGoalType());
      goalRepository.save(existingGoal);
    }
  }
}
