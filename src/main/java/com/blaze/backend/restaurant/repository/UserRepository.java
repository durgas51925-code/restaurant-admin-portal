package com.blaze.backend.restaurant.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blaze.backend.restaurant.entity.User;

public interface UserRepository
        extends JpaRepository<User, Long>
{
    Optional<User> findByUsername(String username);
}