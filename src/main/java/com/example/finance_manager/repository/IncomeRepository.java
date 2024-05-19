package com.example.finance_manager.repository;

import com.example.finance_manager.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
  List<Income> findAllByPersonEmail(String email);
}
