package com.example.finance_manager.service;

import com.example.finance_manager.model.Income;
import com.example.finance_manager.repository.IncomeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IncomeService {

  private IncomeRepository incomeRepository;

  public void createIncome(Income income) {

    incomeRepository.save(income);
  }

  public void deleteIncome(Long id) {

    incomeRepository.deleteById(id);
  }

  public List<Income> fetchIncomes() {

    return incomeRepository.findAll();
  }
}
