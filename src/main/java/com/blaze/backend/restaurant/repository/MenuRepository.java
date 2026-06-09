package com.blaze.backend.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blaze.backend.restaurant.entity.MenuItem;

public interface MenuRepository extends JpaRepository<MenuItem, Long> 
{
	
}