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

// Travel, Realestate, Car, Boat
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Goal {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  private BigDecimal cost;

  private Date dateOfOccurrence;
}
