package com.blaze.backend.restaurant.dto;

import java.util.List;

import com.blaze.backend.restaurant.entity.OrderStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OrderDTO 
{

    private Long id;
    
    @NotBlank(message = "Customer name is required")
    private String customerName;

    @NotNull(message = "Table number is required")
    private Integer tableNumber;

    @NotNull(message = "Status is required")
    private OrderStatus status;
    
    private Double totalAmount;
    
    private List<Long> menuItemIds;

    public OrderDTO()
    {
    	
    }

    public OrderDTO(Long id, String customerName, Integer tableNumber,Double totalAmount, OrderStatus status,List<Long> menuItemIds)
    {
        this.id = id;
        this.customerName = customerName;
        this.tableNumber = tableNumber;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public String getCustomerName() 
    {
        return customerName;
    }

    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public Integer getTableNumber() 
    {
        return tableNumber;
    }

    public void setTableNumber(Integer tableNumber) 
    {
        this.tableNumber = tableNumber;
    }

    public Double getTotalAmount() 
    {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) 
    {
        this.totalAmount = totalAmount;
    }

    public OrderStatus getStatus() 
    {
        return status;
    }

    public void setStatus(OrderStatus status) 
    {
        this.status = status;
    }
    
    public List<Long> getMenuItemIds()
    {
        return menuItemIds;
    }

    public void setMenuItemIds(List<Long> menuItemIds)
    {
        this.menuItemIds = menuItemIds;
    }
}