package com.example.finance_manager.service;

import com.example.finance_manager.model.Income;
import com.example.finance_manager.repository.IncomeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

  public void updateIncome(Long id, Income updatedIncome) {
    Optional<Income> existingIncomeOptional = incomeRepository.findById(id);
    if (existingIncomeOptional.isPresent()) {
      Income existingIncome = existingIncomeOptional.get();
      existingIncome.setName(updatedIncome.getName());
      existingIncome.setAnnualMonthlyValue(updatedIncome.getAnnualMonthlyValue());
      existingIncome.setStartDate(updatedIncome.getStartDate());
      existingIncome.setTerminationDate(updatedIncome.getTerminationDate());
      existingIncome.setInterestRate(updatedIncome.getInterestRate());
      incomeRepository.save(existingIncome);
    }
  }
}
