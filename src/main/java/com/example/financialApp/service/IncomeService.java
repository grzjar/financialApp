package com.example.financialApp.service;

import com.example.financialApp.model.Income;
import com.example.financialApp.repository.IncomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    //istnieje problem z nadpisywaniem się obiektów w liście/bazie danych
    public List<Income> getAll(Long id){
        return incomeRepository.findAllByAccount_Id(id);
    }

    public Income addNew(Income income){
        return incomeRepository.save(income);
    }

    public Optional<Income> getById(long id) {
        return incomeRepository.findById(id);
    }

    public void edit(Income income) {
        Optional<Income> i1 = getById(income.getId());
        if(i1.isPresent()){
            Income i2 = i1.get();
            if(income.getCategory() != null){
                i2.setCategory(income.getCategory());
            }
            if(income.getDescription() != null){
                i2.setDescription(income.getDescription());
            }
            if(income.getValue() != null){
                i2.setValue(income.getValue());
            }
            incomeRepository.save(i2);
        }
    }

    public void delete(long id) {
        Optional<Income> i1 = getById(id);
        if(i1.isPresent()){
            incomeRepository.deleteById(id);
        }
    }
}
