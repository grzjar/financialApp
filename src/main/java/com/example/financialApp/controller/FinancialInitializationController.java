package com.example.financialApp.controller;

import com.example.financialApp.model.User;
import com.example.financialApp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FinancialInitializationController {

    private UserService userService;

    public FinancialInitializationController(UserService u){
        userService = u;
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/create")
    public String create(User user){
        userService.addNew(user);
        return "redirect:/";
    }
}
