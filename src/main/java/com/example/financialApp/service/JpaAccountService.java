package com.example.financialApp.service;

import com.example.financialApp.model.Account;
import com.example.financialApp.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpaAccountService implements AccountService {

    private final AccountRepository accountRepository;

    public JpaAccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account addNew(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> getById(long id) {
        return accountRepository.findById(id);
    }

    @Override
    public void edit(Account account) {
        Optional<Account> a1 = getById(account.getId());
        if(a1.isPresent()){
            Account a2 = a1.get();
            if(account.getAccountName() != null){
                a2.setAccountName(account.getAccountName());
            }
            accountRepository.save(a2);
        }
    }

    @Override
    public void delete(long id) {
        Optional<Account> a1 = getById(id);
        if(a1.isPresent()){
            accountRepository.deleteById(id);
        }
    }
}
