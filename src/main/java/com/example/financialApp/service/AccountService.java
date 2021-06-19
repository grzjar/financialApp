package com.example.financialApp.service;

import com.example.financialApp.model.Account;

import java.util.List;
import java.util.Optional;

//Crud
public interface AccountService {

    List<Account> getAll();

    Account addNew(Account account);

    Optional<Account> getById(long id);

    void edit(Account account);

    void delete(long id);

}
