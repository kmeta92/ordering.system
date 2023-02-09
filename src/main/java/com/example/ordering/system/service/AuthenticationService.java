package com.example.ordering.system.service;

import com.example.ordering.system.model.User;
import com.example.ordering.system.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {


    private final AuthenticationRepository authenticationRepository;

    @Autowired
    public AuthenticationService(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    public String signUp(User user){
        return user.getName();
    }

    public User getUser(Integer userId) {

        Optional<User> user = authenticationRepository.findById(userId);
        if(!user.isPresent()){
            throw new RuntimeException("User not found!");
        }
        return user.get();
    }

    public void createOrUpdateUser(User user) {
        if (null == user.getId()) {
            createUser(user);
            return;
        }
        updateUser(user);
    }

    private void createUser(User user){
        authenticationRepository.save(user);
    }

    private void updateUser(User user){
        authenticationRepository.save(user);
    }

    private void deleteUser(Integer userId){
        authenticationRepository.deactivateUser(userId);
    }

}
