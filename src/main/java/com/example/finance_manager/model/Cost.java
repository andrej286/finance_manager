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
public class Cost {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String description;
  private BigDecimal amount;
  private Date dateOfPayment;

  @Enumerated(value = EnumType.STRING)
  private CostType costType;

  @ManyToOne
  @JoinColumn(name = "person_id")
  @JsonBackReference
  private Person person;

  @Override
  public String toString() {
    return "Cost{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", amount=" + amount +
            ", dateOfPayment=" + dateOfPayment +
            ", costType=" + costType +
            ", person=" + person +
            '}';
  }
}
