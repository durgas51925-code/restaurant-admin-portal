package com.blaze.backend.restaurant.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "menu_items")
public class MenuItem 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;   
    private Double price;
    private boolean available;

    public MenuItem() 
    {
    	
    }

    public MenuItem(Long id, String name, String category, Double price, boolean available) 
    {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.available = available;
    }

    
    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getCategory() 
    {
        return category;
    }

    public void setCategory(String category) 
    {
        this.category = category;
    }

    public Double getPrice() 
    {
        return price;
    }

    public void setPrice(Double price) 
    {
        this.price = price;
    }

    public boolean isAvailable() 
    {
        return available;
    }

    public void setAvailable(boolean available) 
    {
        this.available = available;
    }
}