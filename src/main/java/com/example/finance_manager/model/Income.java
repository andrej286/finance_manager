package com.example.finance_manager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Income {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  private String name;
  private String description;
  private BigDecimal annualMonthlyValue;
  private Date startDate;
  private Date terminationDate;
  private BigDecimal interestRate;

  @ManyToOne
  @JoinColumn(name = "person_id")
  @JsonBackReference
  private Person person;

  @Override
  public String toString() {
    return "Income{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", annualMonthlyValue=" + annualMonthlyValue +
            ", startDate=" + startDate +
            ", terminationDate=" + terminationDate +
            ", interestRate=" + interestRate +
            ", person=" + person +
            '}';
  }
}
