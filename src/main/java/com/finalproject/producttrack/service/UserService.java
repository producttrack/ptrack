package com.finalproject.producttrack.service;

import com.finalproject.producttrack.entities.User;
import com.finalproject.producttrack.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveOrUpdateUser(User user) {
        return userRepository.save(user);
    }

    public boolean userExistWithProvidedEmail(String email) {
        return userRepository.findOneByEmail(email) != null ;
    }

    public User getUserByLogin(String login) {
        return userRepository.findOneByLogin(login);
    }
}
