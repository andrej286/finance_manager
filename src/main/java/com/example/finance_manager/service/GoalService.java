package com.example.finance_manager.service;

import com.example.finance_manager.repository.GoalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GoalService {

  private GoalRepository goalRepository;
}
