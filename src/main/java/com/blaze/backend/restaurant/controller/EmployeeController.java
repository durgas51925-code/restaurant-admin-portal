package com.blaze.backend.restaurant.controller;

import java.util.List;
import org.springframework.data.domain.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blaze.backend.restaurant.dto.EmployeeDTO;
import com.blaze.backend.restaurant.response.ApiResponse;
import com.blaze.backend.restaurant.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController 
{

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ApiResponse<EmployeeDTO> createEmployee( @Valid @RequestBody EmployeeDTO dto) 
    {
    	
        EmployeeDTO saved = employeeService.saveEmployee(dto);
        
        return new ApiResponse<>
        (
                "success",
                "Employee created successfully",
                saved 
        );
    }

    @GetMapping
    public ApiResponse<List<EmployeeDTO>> getAllEmployees() 
    {

        List<EmployeeDTO> list = employeeService.getAllEmployees();

        return new ApiResponse<>
        (
                "success",
                "Employees fetched successfully",
                list
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<EmployeeDTO> getById(@PathVariable Long id) 
    {

        EmployeeDTO dto = employeeService.getEmployeeById(id);

        return new ApiResponse<>
        (
                "success",
                "Employee fetched successfully",
                dto
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable Long id) 
    {

        String msg = employeeService.deleteEmployee(id);

        return new ApiResponse<>
        (
                "success",
                msg,
                null
        );
    }
    

}