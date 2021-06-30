package com.example.financialApp.controller;

import com.example.financialApp.model.Category;
import com.example.financialApp.model.Income;
import com.example.financialApp.service.AccountService;
import com.example.financialApp.service.CategoryService;
import com.example.financialApp.service.IncomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/logged/")
public class IncomeController {

    private IncomeService incomeService;
    private AccountService accountService;
    private CategoryService categoryService;

    public IncomeController(IncomeService incomeService, AccountService accountService, CategoryService categoryService) {
        this.incomeService = incomeService;
        this.accountService = accountService;
        this.categoryService = categoryService;
    }

    @GetMapping("show/{id}/createIncome")
    public String create(Model model, @PathVariable Long id){
        model.addAttribute("categories", categoryService.getAll(id));
        model.addAttribute("income", new Income());
        return "logged/income/createIncome";
    }

    @PostMapping("show/{id}/createIncome")
    public String create(Income income, @PathVariable Long id){
        income.setAccount(accountService.getById(id).get());
        income.setId(null);
        incomeService.addNew(income);
        return "redirect:/logged/";
    }

    @GetMapping("show/{id1}/show-income/{id2}")
    public String show(Model model, @PathVariable Long id1, @PathVariable Long id2){
        model.addAttribute("categories", categoryService.getAll(id1));
        model.addAttribute("id", id1);
        model.addAttribute("income", incomeService.getById(id2).get());
        return "logged/income/showOneIncome";
    }

    @GetMapping("show/{id1}/edit-income/{id2}")
    public String edit(Model model, @PathVariable Long id1, @PathVariable Long id2){
        model.addAttribute("categories", categoryService.getAll(id1));
        model.addAttribute("id", id1);
        model.addAttribute("income", incomeService.getById(id2).get());
        return "logged/income/editIncome";
    }

    @PostMapping("show/{id1}/edit-income/{id2}")
    public String edit(Income income, @PathVariable Long id1, Model model, @PathVariable Long id2){
        model.addAttribute("id", id1);
        incomeService.edit(income);
        return "redirect:/logged/show/{id1}";
    }

    @GetMapping("show/{id1}/delete-income/{id2}")
    private String delete(Model model, @PathVariable Long id1, @PathVariable Long id2){
        model.addAttribute("categories", categoryService.getAll(id1));
        model.addAttribute("id", id1);
        model.addAttribute("income", incomeService.getById(id2).get());
        return "logged/income/deleteIncome";
    }

    @PostMapping("show/{id1}/delete-income/{id2}")
    private String delete(Income income, @PathVariable Long id1, Model model){
        model.addAttribute("id", id1);
        incomeService.delete(income.getId());
        return "redirect:/logged/show/{id1}";
    }


}
