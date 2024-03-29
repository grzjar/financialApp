package com.example.financialApp.controller;

import com.example.financialApp.model.User;
import com.example.financialApp.service.UserManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;;

@Controller
public class FinancialInitializationController {

    private UserManagerService userManagerService;

    public FinancialInitializationController(UserManagerService userManagerService) {
        this.userManagerService = userManagerService;
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/create")
    public String create(User user){
        userManagerService.registerUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
