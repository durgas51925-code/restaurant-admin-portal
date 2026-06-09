package com.blaze.backend.restaurant.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blaze.backend.restaurant.dto.LoginRequest;
import com.blaze.backend.restaurant.jwt.JwtUtil;
import com.blaze.backend.restaurant.entity.User;
import com.blaze.backend.restaurant.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController
{
    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Map<String,String> login(@RequestBody LoginRequest request)
    {
        User user =
                userService.login(
                        request.getUsername());

        if(user == null)
        {
            throw new RuntimeException("User not found");
        }

        if(!user.getPassword().equals(request.getPassword()))
        {
            throw new RuntimeException("Invalid password");
        }

        String token =
                jwtUtil.generateToken(user.getUsername(),user.getRole().name());

        return Map.of("token", token);
    
    }
}