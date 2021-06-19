package com.example.financialApp.controller;

import com.example.financialApp.model.User;
import com.example.financialApp.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class FinancialInitializationController {

    private UserService userService;

    public FinancialInitializationController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/create")
    public String create(User user){
        User u = new User();
        u.setUsername(user.getUsername());
        u.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        u.setEmail(user.getEmail());
        userService.addNew(u);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(User user){
        List<User> users = userService.getAll();
        for(User u : users){
            if(u.getEmail().equals(user.getEmail()) && BCrypt.checkpw(user.getPassword(), u.getPassword())){
                return "redirect:/";
            }
        }
        return "redirect:/blad";
    }

}
