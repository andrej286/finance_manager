package com.example.finance_manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

// Car, House
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Asset {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  private String description;

  private BigDecimal value;
}
