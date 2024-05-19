package com.example.finance_manager.service;

import com.example.finance_manager.model.Goal;
import com.example.finance_manager.model.Person;
import com.example.finance_manager.repository.GoalRepository;
import com.example.finance_manager.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GoalService {

  private GoalRepository goalRepository;
  private PersonRepository personRepository;

  public List<Goal> fetchGoals(String email) {

    return goalRepository.findAllByPersonEmail(email);
  }

  public void createGoal(Goal goal, String email) {
    Optional<Person> personOptional = personRepository.findByEmail(email);
    if (personOptional.isPresent()) {
      Person person = personOptional.get();
      goal.setPerson(person);
      goalRepository.save(goal);
    } else {
      throw new RuntimeException("Person with email " + email + " not found");
    }
  }

  public void deleteGoal(Long id, String email) {
    Optional<Goal> goalOptional = goalRepository.findById(id);
    if (goalOptional.isPresent()) {
      Goal goal = goalOptional.get();
      if (goal.getPerson().getEmail().equals(email)) {
        goalRepository.deleteById(id);
      } else {
        throw new RuntimeException("Unauthorized to delete this goal");
      }
    } else {
      throw new RuntimeException("Goal not found");
    }
  }

  public void updateGoal(Long id, Goal updatedGoal, String email) {
    Optional<Goal> existingGoalOptional = goalRepository.findById(id);
    if (existingGoalOptional.isPresent()) {
      Goal existingGoal = existingGoalOptional.get();
      if (existingGoal.getPerson().getEmail().equals(email)) {
        existingGoal.setName(updatedGoal.getName());
        existingGoal.setDescription(updatedGoal.getDescription());
        existingGoal.setAmount(updatedGoal.getAmount());
        existingGoal.setDateOfOccurrence(updatedGoal.getDateOfOccurrence());
        existingGoal.setGoalType(updatedGoal.getGoalType());
        goalRepository.save(existingGoal);
      } else {
        throw new RuntimeException("Unauthorized to update this goal");
      }
    } else {
      throw new RuntimeException("Goal not found");
    }
  }
}
