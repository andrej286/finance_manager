package com.example.finance_manager.repository;

import com.example.finance_manager.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {

  @Query("SELECT g FROM Goal g JOIN g.person p WHERE p.email = :email")
  List<Goal> findAllByPersonEmail(@Param("email") String email);
}
