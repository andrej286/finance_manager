package com.example.finance_manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Income {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  private String name;
  private BigDecimal annualMonthlyValue;
  private Date startDate;
  private Date terminationDate;
  private BigDecimal interestRate;
  // TODO: 5/3/2024 : Add description.
}
