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
public class Asset {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  private String name;
  private String description;
  private BigDecimal value;
  private BigDecimal interestRate;
  private Date dateOfAcquirement;

  @ManyToOne
  @JoinColumn(name = "person_id")
  @JsonBackReference
  private Person person;

  @Override
  public String toString() {
    return "Asset{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", value=" + value +
            ", interestRate=" + interestRate +
            ", dateOfAcquirement=" + dateOfAcquirement +
            ", person=" + person +
            '}';
  }
}
