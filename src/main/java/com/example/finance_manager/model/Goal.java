package com.example.finance_manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Goal {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  private String name;
  private String description;
  private BigDecimal amount;
  private Date dateOfOccurrence;

  @Enumerated(value = EnumType.STRING)
  private GoalType goalType;
}
