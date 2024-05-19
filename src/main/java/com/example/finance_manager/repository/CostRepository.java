package com.example.finance_manager.repository;

import com.example.finance_manager.model.Cost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CostRepository extends JpaRepository<Cost, Long> {
  List<Cost> findAllByPersonEmail(String email);
}