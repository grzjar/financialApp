package com.example.financialApp.controller;

import com.example.financialApp.model.Account;
import com.example.financialApp.model.Income;
import com.example.financialApp.model.Outcome;
import com.example.financialApp.model.User;
import com.example.financialApp.service.AccountService;
import com.example.financialApp.service.CustomUserDetailService;
import com.example.financialApp.service.IncomeService;
import com.example.financialApp.service.OutcomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/logged")

public class AccountController {

    private AccountService accountService;
    private IncomeService incomeService;
    private OutcomeService outcomeService;

    public AccountController(AccountService accountService, IncomeService incomeService, OutcomeService outcomeService, CustomUserDetailService userDetailService) {
        this.accountService = accountService;
        this.incomeService = incomeService;
        this.outcomeService = outcomeService;
    }

    @GetMapping("/")
    public String showAll(Model model){
        List<Account> accounts = accountService.getAll();
        User user = accountService.getUser();
        model.addAttribute("user", user);
        model.addAttribute("accounts", accounts);
        return "logged/logged";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("account", new Account());
        return "logged/createAccount";
    }

    @PostMapping("/create")
    public String create(Account account){
        accountService.addNew(account);
        return "redirect:/logged/";
    }

    @GetMapping("/show/{id}")
    public String showOne(Model model, @PathVariable Long id){
        List<Income> incomes = incomeService.getAll(id);
        List<Outcome> outcomes = outcomeService.getAll(id);
        model.addAttribute("incomes", incomes);
        model.addAttribute("outcomes", outcomes);
        model.addAttribute("id", id);
        Account account = accountService.getById(id).get();
//        account.setAccountValue(accountService.sum(account.getSumIncome(), account.getSumOutcome(), account.getAccountValue()));
        model.addAttribute("account", account);
        return "logged/showOneAccount";
    }

    @GetMapping("/edit")
    private String edit(Model model, Long id){
        model.addAttribute("account", accountService.getById(id));
        return "logged/editAccount";
    }

    @PostMapping("/edit")
    private String edit(Account account){
        accountService.edit(account);
        return "redirect:/logged/";
    }

    @GetMapping("/delete")
    private String delete(Model model, Long id){
        model.addAttribute("account", accountService.getById(id).get());
        return "logged/delete";
    }

    @PostMapping("/delete")
    private String delete(Account account){
        accountService.delete(account.getId());
        return "redirect:/logged/";
    }
}
