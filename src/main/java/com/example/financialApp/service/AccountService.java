package com.example.financialApp.service;

import com.example.financialApp.model.Account;
import com.example.financialApp.model.User;
import com.example.financialApp.repository.AccountRepository;
import com.example.financialApp.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService{

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountService(AccountRepository accountRepository, UserRepository userRepository){
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    //wydzielenie metody, by mieć dostęp do Usera
    public User getUser(){
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(()-> new UsernameNotFoundException("Nie ma takiego użytkownika"));
        return user;
    }

    public List<Account> getAll() {
        return accountRepository.findAccountsByUser(getUser());
    }

    public Account addNew(Account account) {
        account.setUser(getUser());
        return accountRepository.save(account);
    }

    public Optional<Account> getById(long id) {
        return accountRepository.findById(id);
    }



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

    public void delete(long id) {
        Optional<Account> a1 = getById(id);
        if(a1.isPresent()){
            accountRepository.deleteById(id);
        }
    }

//    public Double sum(Double sumIncome, Double sumOutcome, Double accountValue) {
//        double res = accountValue;
//        if(sumIncome != 0){
//            res += sumIncome;
//        }
//        if(sumOutcome != 0){
//            res -= sumOutcome;
//        }
//        return res;
//    }
}
