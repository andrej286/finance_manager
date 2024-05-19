package com.example.finance_manager.service;

import com.example.finance_manager.model.Income;
import com.example.finance_manager.model.Person;
import com.example.finance_manager.repository.IncomeRepository;
import com.example.finance_manager.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IncomeService {

  private IncomeRepository incomeRepository;
  private PersonRepository personRepository;

  public List<Income> fetchIncomes(String email) {
    return incomeRepository.findAllByPersonEmail(email);
  }

  public void createIncome(Income income, String email) {
    Optional<Person> personOptional = personRepository.findByEmail(email);
    if (personOptional.isPresent()) {
      Person person = personOptional.get();
      income.setPerson(person);
      incomeRepository.save(income);
    } else {
      throw new RuntimeException("Person with email " + email + " not found");
    }
  }

  public void deleteIncome(Long id, String email) {
    Optional<Income> incomeOptional = incomeRepository.findById(id);
    if (incomeOptional.isPresent()) {
      Income income = incomeOptional.get();
      if (income.getPerson().getEmail().equals(email)) {
        incomeRepository.deleteById(id);
      } else {
        throw new RuntimeException("Unauthorized action for email " + email);
      }
    } else {
      throw new RuntimeException("Income with id " + id + " not found");
    }
  }

  public void updateIncome(Long id, Income updatedIncome, String email) {
    Optional<Income> existingIncomeOptional = incomeRepository.findById(id);
    if (existingIncomeOptional.isPresent()) {
      Income existingIncome = existingIncomeOptional.get();
      if (existingIncome.getPerson().getEmail().equals(email)) {
        existingIncome.setName(updatedIncome.getName());
        existingIncome.setDescription(updatedIncome.getDescription());
        existingIncome.setAnnualMonthlyValue(updatedIncome.getAnnualMonthlyValue());
        existingIncome.setStartDate(updatedIncome.getStartDate());
        existingIncome.setTerminationDate(updatedIncome.getTerminationDate());
        existingIncome.setInterestRate(updatedIncome.getInterestRate());
        incomeRepository.save(existingIncome);
      } else {
        throw new RuntimeException("Unauthorized action for email " + email);
      }
    } else {
      throw new RuntimeException("Income with id " + id + " not found");
    }
  }
}
