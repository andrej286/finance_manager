package com.example.finance_manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  private String name;
  private String surname;
  private Date dateOfBirth;
  @OneToMany
  private List<Asset> assets;
  @OneToMany
  private List<Goal> goals;
  @OneToMany
  private List<Income> incomes;
  @OneToMany
  private List<Cost> costs;
}
