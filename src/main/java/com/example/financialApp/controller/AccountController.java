package com.example.financialApp.controller;

import com.example.financialApp.model.Account;
import com.example.financialApp.service.AccountService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/logged")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("/")
    public String showAll(Model model){
        List<Account> accounts = accountService.getAll();
        model.addAttribute("accounts", accounts);
        return "logged/logged";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("account", new Account());
        return "logged/createAccount";
    }

    @PostMapping("/create")
    public String create(Account account, Authentication currentUser){
        accountService.addNew(account, currentUser.getName());
        return "redirect:/logged/";
    }

    @GetMapping("/show")
    public String showOne(Model model, Long id){
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
        accountService.delete(account.getId());
        return "redirect:/logged/";
    }
}
