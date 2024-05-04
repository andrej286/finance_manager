package com.example.finance_manager.service;

import com.example.finance_manager.model.Cost;
import com.example.finance_manager.repository.CostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CostService {

  private CostRepository costRepository;

  public void createCost(Cost cost) {

    costRepository.save(cost);
  }

  public void deleteCost(Long id) {

    costRepository.deleteById(id);
  }

  public List<Cost> fetchCosts() {

    return costRepository.findAll();
  }

  public void updateCost(Long id, Cost updatedCost) {

    Optional<Cost> existingCostOptional = costRepository.findById(id);
    if (existingCostOptional.isPresent()) {
      Cost existingCost = existingCostOptional.get();
      existingCost.setName(updatedCost.getName());
      existingCost.setDescription(updatedCost.getDescription());
      existingCost.setAmount(updatedCost.getAmount());
      existingCost.setDateOfPayment(updatedCost.getDateOfPayment());
      existingCost.setCostType(updatedCost.getCostType());
      costRepository.save(existingCost);
    }
  }
}
