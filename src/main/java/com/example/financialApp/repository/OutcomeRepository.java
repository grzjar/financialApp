package com.example.financialApp.repository;

import com.example.financialApp.model.Outcome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutcomeRepository extends JpaRepository<Outcome, Long> {

    List<Outcome> findAllByAccount_Id(Long id);
}
