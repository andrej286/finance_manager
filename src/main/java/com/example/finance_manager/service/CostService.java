package com.example.finance_manager.service;

import com.example.finance_manager.model.Cost;
import com.example.finance_manager.model.Person;
import com.example.finance_manager.repository.CostRepository;
import com.example.finance_manager.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CostService {

  private CostRepository costRepository;
  private PersonRepository personRepository;

  public List<Cost> fetchCosts(String email) {
    return costRepository.findAllByPersonEmail(email);
  }

  public void createCost(Cost cost, String email) {
    Optional<Person> personOptional = personRepository.findByEmail(email);
    if (personOptional.isPresent()) {
      Person person = personOptional.get();
      cost.setPerson(person);
      costRepository.save(cost);
    } else {
      throw new RuntimeException("Person with email " + email + " not found");
    }
  }

  public void deleteCost(Long id, String email) {
    Optional<Cost> costOptional = costRepository.findById(id);
    if (costOptional.isPresent()) {
      Cost cost = costOptional.get();
      if (cost.getPerson().getEmail().equals(email)) {
        costRepository.deleteById(id);
      } else {
        throw new RuntimeException("Unauthorized action for email " + email);
      }
    } else {
      throw new RuntimeException("Cost with id " + id + " not found");
    }
  }

  public void updateCost(Long id, Cost updatedCost, String email) {
    Optional<Cost> existingCostOptional = costRepository.findById(id);
    if (existingCostOptional.isPresent()) {
      Cost existingCost = existingCostOptional.get();
      if (existingCost.getPerson().getEmail().equals(email)) {
        existingCost.setName(updatedCost.getName());
        existingCost.setDescription(updatedCost.getDescription());
        existingCost.setAmount(updatedCost.getAmount());
        existingCost.setDateOfPayment(updatedCost.getDateOfPayment());
        existingCost.setCostType(updatedCost.getCostType());
        costRepository.save(existingCost);
      } else {
        throw new RuntimeException("Unauthorized action for email " + email);
      }
    } else {
      throw new RuntimeException("Cost with id " + id + " not found");
    }
  }
}
