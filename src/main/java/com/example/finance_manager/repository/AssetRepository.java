package com.example.finance_manager.repository;

import com.example.finance_manager.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
  List<Asset> findAllByPersonEmail(String email);
}