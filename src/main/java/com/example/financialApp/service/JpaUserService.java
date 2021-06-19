package com.example.financialApp.service;

import com.example.financialApp.model.User;
import com.example.financialApp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpaUserService implements UserService {

    private final UserRepository userRepository;

    public JpaUserService(UserRepository uR){
        userRepository = uR;
    }

    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Override
    public User addNew(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void edit(User user) {
        Optional<User> u1 = getById(user.getId());
        if(u1.isPresent()){
            User u2 = u1.get();
            if(u2.getUsername() != null){
                u2.setUsername(user.getUsername());
            }
            if(u2.getPassword() != null){
                u2.setPassword(user.getPassword());
            }
            userRepository.save(u2);
        }
    }

    @Override
    public void delete(long id) {
        Optional<User> user = getById(id);
        if(user.isPresent()){
            userRepository.deleteById(id);
        }
    }

}
