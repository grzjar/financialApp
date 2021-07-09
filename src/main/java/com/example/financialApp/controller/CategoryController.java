package com.example.financialApp.controller;

import com.example.financialApp.model.Category;
import com.example.financialApp.service.AccountService;
import com.example.financialApp.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/logged/")
public class CategoryController {

    private CategoryService categoryService;
    private AccountService accountService;

    public CategoryController(CategoryService categoryService, AccountService accountService) {
        this.categoryService = categoryService;
        this.accountService = accountService;
    }

    @GetMapping("show/{id}/createCategory")
    public String create(Model model){
        model.addAttribute("category", new Category());
        return "logged/category/addCategory";
    }

    @PostMapping("show/{id}/createCategory")
    public String create(Category category, @PathVariable Long id){
        category.setAccount(accountService.getById(id).get());
        category.setId(null);
        categoryService.addNew(category);
        return "redirect:/logged/show/{id}/";
    }

    //w przyszłości może wyświetlanie wydatków/wpływów per kategoria
    @GetMapping("show/{id1}/show-category/{id2}")
    public String show(Model model, @PathVariable Long id1, @PathVariable Long id2){
        model.addAttribute("id", id1);
        model.addAttribute("category", categoryService.getById(id2).get());
        return "logged/category/showOneCategory";
    }

    @GetMapping("show/{id}/show-all")
    public String showAll(Model model, @PathVariable Long id){
        List<Category> categories = categoryService.getAllX(id);
        model.addAttribute("categories", categories);
        return "logged/category/showAll";
    }

    @GetMapping("show/{id1}/edit-category/{id2}")
    public String edit(Model model, @PathVariable Long id1, @PathVariable Long id2){
        model.addAttribute("id", id1);
        model.addAttribute("category", categoryService.getById(id2).get());
        return "logged/category/editCategory";
    }

    @PostMapping("show/{id1}/edit-category/{id2}")
    public String edit(Category category, @PathVariable Long id1, Model model){
        model.addAttribute("id", id1);
        categoryService.edit(category);
        return "redirect:/logged/show/{id1}";
    }

    @GetMapping("show/{id1}/delete-category/{id2}")
    private String delete(Model model, @PathVariable Long id1, @PathVariable Long id2){
        model.addAttribute("id", id1);
        model.addAttribute("category", categoryService.getById(id2).get());
        return "logged/category/deleteCategory";
    }

    @PostMapping("show/{id1}/delete-category/{id2}")
    private String delete(Category category, @PathVariable Long id1, Model model){
        model.addAttribute("id", id1);
        categoryService.delete(category.getId());
        return "redirect:/logged/show/{id1}";
    }
}
