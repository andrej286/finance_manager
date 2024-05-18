package com.example.finance_manager.repository;

import com.example.finance_manager.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

  Optional<Person> findByEmail(String email);
}
