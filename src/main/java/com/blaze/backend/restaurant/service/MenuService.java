package com.blaze.backend.restaurant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blaze.backend.restaurant.dto.MenuDTO;
import com.blaze.backend.restaurant.entity.MenuItem;
import com.blaze.backend.restaurant.repository.MenuRepository;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;


    public MenuDTO addItem(MenuDTO dto) 
    {

        MenuItem item = new MenuItem();

        item.setName(dto.getName());
        item.setCategory(dto.getCategory());
        item.setPrice(dto.getPrice());
        item.setAvailable(dto.isAvailable());

        MenuItem saved = menuRepository.save(item);

        dto.setId(saved.getId());

        return dto;
    }


    public List<MenuDTO> getAllItems() 
    {

        List<MenuItem> items = menuRepository.findAll();
        List<MenuDTO> list = new ArrayList<>();

        for (MenuItem item : items) {

            MenuDTO dto = new MenuDTO();

            dto.setId(item.getId());
            dto.setName(item.getName());
            dto.setCategory(item.getCategory());
            dto.setPrice(item.getPrice());
            dto.setAvailable(item.isAvailable());

            list.add(dto);
        }

        return list;
    }
}