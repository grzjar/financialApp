package com.example.financialApp.controller;

import com.example.financialApp.model.Income;
import com.example.financialApp.model.Outcome;
import com.example.financialApp.service.AccountService;
import com.example.financialApp.service.OutcomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/logged/")
public class OutcomeController {

    private OutcomeService outcomeService;
    private AccountService accountService;

    public OutcomeController(OutcomeService outcomeService, AccountService accountService) {
        this.outcomeService = outcomeService;
        this.accountService = accountService;
    }

    @ModelAttribute("categories")
    public List<String> selectCategory(){
        String[] a = new String[]{"cat1", "cat2", "cat3"};
        return Arrays.asList(a);
    }

    @GetMapping("show/{id}/createOutcome")
    public String create(Model model){
        model.addAttribute("outcome", new Outcome());
        return "logged/outcome/createOutcome";
    }

    @PostMapping("show/{id}/createOutcome")
    public String create(Outcome outcome, @PathVariable Long id){
        outcome.setAccount(accountService.getById(id).get());
        outcome.setId(null);
        outcomeService.addNew(outcome);
        return "redirect:/logged/";
    }

    @GetMapping("show/{id1}/show-outcome/{id2}")
    public String show(Model model, @PathVariable Long id1, @PathVariable Long id2){
        model.addAttribute("id", id1);
        model.addAttribute("outcome", outcomeService.getById(id2).get());
        return "logged/outcome/showOneOutcome";
    }

    @GetMapping("show/{id1}/edit-outcome/{id2}")
    public String edit(Model model, @PathVariable Long id1, @PathVariable Long id2){
        model.addAttribute("id", id1);
        model.addAttribute("outcome", outcomeService.getById(id2).get());
        return "logged/outcome/editOutcome";
    }

    @PostMapping("show/{id1}/edit-outcome/{id2}")
    public String edit(Outcome outcome, @PathVariable Long id1, Model model){
        model.addAttribute("id", id1);
        outcomeService.edit(outcome);
        return "redirect:/logged/show/{id1}";
    }

    @GetMapping("show/{id1}/delete-outcome/{id2}")
    private String delete(Model model, @PathVariable Long id1, @PathVariable Long id2){
        model.addAttribute("id", id1);
        model.addAttribute("outcome", outcomeService.getById(id2).get());
        return "logged/outcome/deleteOutcome";
    }

    @PostMapping("show/{id1}/delete-outcome/{id2}")
    private String delete(Outcome outcome, @PathVariable Long id1, Model model){
        model.addAttribute("id", id1);
        outcomeService.delete(outcome.getId());
        return "redirect:/logged/show/{id1}";
    }
}
