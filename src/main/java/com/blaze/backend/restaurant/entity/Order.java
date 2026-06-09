package com.blaze.backend.restaurant.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    private Integer tableNumber;

    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    
    @ManyToMany
    @JoinTable(
            name = "order_menu_items",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_item_id"))
    private List<MenuItem> menuItems;

    public Order()
    {
    	
    }
  
    public Order(Long id, String customerName, Integer tableNumber,Double totalAmount, OrderStatus status, List<MenuItem> menuItems) 
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

    public List<MenuItem> getMenuItems()
    {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems)
    {
        this.menuItems = menuItems;
    }
}