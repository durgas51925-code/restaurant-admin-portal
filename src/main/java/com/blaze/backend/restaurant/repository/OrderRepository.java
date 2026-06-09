package com.blaze.backend.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blaze.backend.restaurant.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>
{
	
}