package com.example.financialApp.repository;

import com.example.financialApp.model.Account;
import com.example.financialApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAccountsByUser(User user);

}
