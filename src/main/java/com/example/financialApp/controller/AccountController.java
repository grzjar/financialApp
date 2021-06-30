package com.example.financialApp.controller;

import com.example.financialApp.model.*;
import com.example.financialApp.service.*;
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
    private CategoryService categoryService;

    public AccountController(AccountService accountService, IncomeService incomeService, OutcomeService outcomeService, CustomUserDetailService userDetailService, CategoryService categoryService) {
        this.accountService = accountService;
        this.incomeService = incomeService;
        this.outcomeService = outcomeService;
        this.categoryService = categoryService;
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
        categoryService.addNew(new Category(null, "Wartość inicjalna", account));
        categoryService.addNew(new Category(null, "Mieszkanie", account));
        categoryService.addNew(new Category(null, "Jedzenie", account));
        return "redirect:/logged/";
    }

    @GetMapping("/show/{id}")
    public String showOne(Model model, @PathVariable Long id){
        List<Income> incomes = incomeService.getAll(id);
        List<Outcome> outcomes = outcomeService.getAll(id);
        model.addAttribute("incomes", incomes);
        model.addAttribute("outcomes", outcomes);
        model.addAttribute("id", id);
        model.addAttribute("account", accountService.getById(id).get());
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
        incomeService.deleteAllById(account.getId());
        outcomeService.deleteAllById(account.getId());
        categoryService.deleteAllById(account.getId());
        accountService.delete(account.getId());
        return "redirect:/logged/";
    }
}
