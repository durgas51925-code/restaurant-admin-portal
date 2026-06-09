package com.blaze.backend.restaurant.controller;

import java.util.List;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blaze.backend.restaurant.dto.MenuDTO;
import com.blaze.backend.restaurant.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController 
{

    @Autowired
    private MenuService menuService;

    @PostMapping
    public MenuDTO addItem(@Valid @RequestBody MenuDTO dto) 
    {
        return menuService.addItem(dto);
    }

    @GetMapping
    public List<MenuDTO> getAllItems() 
    {
        return menuService.getAllItems();
    }
}