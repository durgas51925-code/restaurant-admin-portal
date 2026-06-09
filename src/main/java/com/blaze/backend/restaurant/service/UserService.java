package com.blaze.backend.restaurant.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blaze.backend.restaurant.entity.User;
import com.blaze.backend.restaurant.repository.UserRepository;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public User login(String username)
    {
        Optional<User> user =
                userRepository.findByUsername(username);

        return user.orElse(null);
    }
}