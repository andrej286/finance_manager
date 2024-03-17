package com.example.finance_manager.service;

import com.example.finance_manager.model.Cost;
import com.example.finance_manager.repository.CostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
