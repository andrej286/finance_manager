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

  @ManyToOne
  @JoinColumn(name = "person_id")
  @JsonBackReference
  private Person person;

  @Override
  public String toString() {
    return "Goal{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", amount=" + amount +
            ", dateOfOccurrence=" + dateOfOccurrence +
            ", goalType=" + goalType +
            '}';
  }
}
