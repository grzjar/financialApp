package com.example.financialApp.service;

import com.example.financialApp.model.User;

import java.util.Optional;

public interface UserService {

    User addNew(User user);

    Optional<User> getById(long id);

    void edit(User user);

    void delete(long id);
}
