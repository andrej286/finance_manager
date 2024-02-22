package com.example.finance_manager.service;

import com.example.finance_manager.repository.IncomeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IncomeService {

  private IncomeRepository incomeRepository;
}
