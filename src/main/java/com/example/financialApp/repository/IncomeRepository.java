package com.example.financialApp.repository;

import com.example.financialApp.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

    //w repozytorium mogę zapisać masę zapytań
    List<Income> findAllByAccount_Id(Long id);

}
