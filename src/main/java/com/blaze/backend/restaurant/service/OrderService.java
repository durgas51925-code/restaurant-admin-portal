package com.blaze.backend.restaurant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blaze.backend.restaurant.dto.OrderDTO;
import com.blaze.backend.restaurant.entity.MenuItem;
import com.blaze.backend.restaurant.entity.Order;
import com.blaze.backend.restaurant.repository.MenuRepository;
import com.blaze.backend.restaurant.repository.OrderRepository;

@Service
public class OrderService
{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MenuRepository menuRepository;
  
    public OrderDTO createOrder(OrderDTO dto)
    {
        List<MenuItem> menuItems =
                menuRepository.findAllById(dto.getMenuItemIds());

        double total = 0.0;

        for(MenuItem item : menuItems)
        {
            total += item.getPrice();
        }

        Order order = new Order();

        order.setCustomerName(dto.getCustomerName());
        order.setTableNumber(dto.getTableNumber());
        order.setStatus(dto.getStatus());
        order.setMenuItems(menuItems);
        order.setTotalAmount(total);

        Order saved = orderRepository.save(order);

        dto.setId(saved.getId());
        dto.setTotalAmount(total);

        return dto;
    }

    
    public List<OrderDTO> getAllOrders()
    {
        List<Order> orders = orderRepository.findAll();

        List<OrderDTO> dtoList = new ArrayList<>();

        for(Order order : orders)
        {
            OrderDTO dto = new OrderDTO();

            dto.setId(order.getId());
            dto.setCustomerName(order.getCustomerName());
            dto.setTableNumber(order.getTableNumber());
            dto.setTotalAmount(order.getTotalAmount());
            dto.setStatus(order.getStatus());
            List<Long> menuIds = new ArrayList<>();

            for(MenuItem item : order.getMenuItems())
            {
                menuIds.add(item.getId());
            }

            dto.setMenuItemIds(menuIds);

            dtoList.add(dto);
        }

        return dtoList;
    }

    
    public OrderDTO getOrderById(Long id)
    {
        Order order = orderRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found with id : " + id));

        OrderDTO dto = new OrderDTO();

        dto.setId(order.getId());
        dto.setCustomerName(order.getCustomerName());
        dto.setTableNumber(order.getTableNumber());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setStatus(order.getStatus());
        List<Long> menuIds = new ArrayList<>();

        for(MenuItem item : order.getMenuItems())
        {
            menuIds.add(item.getId());
        }

        dto.setMenuItemIds(menuIds);

        return dto;
    }

 
    public OrderDTO updateOrderStatus(Long id, OrderDTO dto)
    {
        Order order = orderRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found with id : " + id));

        order.setStatus(dto.getStatus());

        Order updated = orderRepository.save(order);

        OrderDTO response = new OrderDTO();

        response.setId(updated.getId());
        response.setCustomerName(updated.getCustomerName());
        response.setTableNumber(updated.getTableNumber());
        response.setTotalAmount(updated.getTotalAmount());
        response.setStatus(updated.getStatus());
        List<Long> menuIds = new ArrayList<>();

        for(MenuItem item : order.getMenuItems())
        {
            menuIds.add(item.getId());
        }

        dto.setMenuItemIds(menuIds);

        return response;
    }

 
    public String deleteOrder(Long id)
    {
        if(!orderRepository.existsById(id))
        {
            throw new RuntimeException("Order not found with id : " + id);
        }

        orderRepository.deleteById(id);

        return "Order deleted successfully";
    }
}