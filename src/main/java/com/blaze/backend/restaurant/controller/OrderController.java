package com.blaze.backend.restaurant.controller;

import java.util.List;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blaze.backend.restaurant.dto.OrderDTO;
import com.blaze.backend.restaurant.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController
{
    @Autowired
    private OrderService orderService;

    
    @PostMapping
    public OrderDTO createOrder(@Valid @RequestBody OrderDTO dto)
    {
        return orderService.createOrder(dto);
    }

    
    @GetMapping
    public List<OrderDTO> getAllOrders()
    {
        return orderService.getAllOrders();
    }

    
    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable Long id)
    {
        return orderService.getOrderById(id);
    }

   
    @PutMapping("/{id}/status")
    public OrderDTO updateOrderStatus(@PathVariable Long id,
                                      @RequestBody OrderDTO dto)
    {
        return orderService.updateOrderStatus(id, dto);
    }


    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id)
    {
        return orderService.deleteOrder(id);
    }
}