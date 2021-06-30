package com.example.financialApp.service;

import com.example.financialApp.model.Outcome;
import com.example.financialApp.repository.OutcomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutcomeService {

    private final OutcomeRepository outcomeRepository;

    public OutcomeService(OutcomeRepository outcomeRepository) {
        this.outcomeRepository = outcomeRepository;
    }

    public List<Outcome> getAll(Long id){
        return outcomeRepository.findAllByAccount_Id(id);
    }

    public Outcome addNew(Outcome outcome){
        return outcomeRepository.save(outcome);
    }

    public Optional<Outcome> getById(long id) {
        return outcomeRepository.findById(id);
    }

    public void edit(Outcome outcome) {
        Optional<Outcome> o1 = getById(outcome.getId());
        if(o1.isPresent()){
            Outcome o2 = o1.get();
            if(outcome.getCategory() != null){
                o2.setCategory(outcome.getCategory());
            }
            if(outcome.getDescription() != null){
                o2.setDescription(outcome.getDescription());
            }
            if(outcome.getValue() != null){
                o2.setValue(outcome.getValue());
            }
            outcomeRepository.save(o2);
        }
    }

    public void delete(long id) {
        Optional<Outcome> o1 = getById(id);
        if (o1.isPresent()) {
            outcomeRepository.deleteById(id);
        }
    }

    public void deleteAllById(long id){
        List<Outcome> list = getAll(id);
        for(Outcome o : list){
            delete(o.getId());
        }
    }
}
