package com.example.financialApp.service;

import com.example.financialApp.model.Category;
import com.example.financialApp.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll(Long id){
        return categoryRepository.findAllByAccount_Id(id);
    }

    public Category addNew(Category category){
        return categoryRepository.save(category);
    }

    public Optional<Category> getById(long id){
        return categoryRepository.findById(id);
    }

    public void delete(long id){
        Optional<Category> cat = getById(id);
        if(cat.isPresent()){
            categoryRepository.deleteById(id);
        }
    }

    public void edit(Category category) {
        Optional<Category> c1 = getById(category.getId());
        if(c1.isPresent()){
            Category c2 = c1.get();
            if(category.getCategoryName() != null){
                c2.setCategoryName(category.getCategoryName());
            }
            categoryRepository.save(c2);
        }
    }

    public void deleteAllById(long id){
        List<Category> list = getAll(id);
        for(Category c : list){
            delete(c.getId());
        }
    }

}
