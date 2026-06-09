package com.blaze.backend.restaurant.service;

import java.util.ArrayList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blaze.backend.restaurant.dto.EmployeeDTO;
import com.blaze.backend.restaurant.entity.Employee;
import com.blaze.backend.restaurant.repository.EmployeeRepository;

@Service
public class EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;


    public EmployeeDTO saveEmployee(EmployeeDTO dto)
    {
        Employee emp = new Employee();

        emp.setName(dto.getName());
        emp.setEmail(dto.getEmail());
        emp.setSalary(dto.getSalary());

        Employee saved = employeeRepository.save(emp);

        dto.setId(saved.getId());

        return dto;
    }

    public List<EmployeeDTO> getAllEmployees() 
    {
        List<Employee> employees = employeeRepository.findAll();

        List<EmployeeDTO> dtoList = new ArrayList<>();

        for (Employee emp : employees) 
        {
            EmployeeDTO dto = new EmployeeDTO();

            dto.setId(emp.getId());
            dto.setName(emp.getName());
            dto.setEmail(emp.getEmail());
            dto.setSalary(emp.getSalary());

            dtoList.add(dto);
        }

        return dtoList;
    }


    public EmployeeDTO getEmployeeById(Long id) 
    {
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        EmployeeDTO dto = new EmployeeDTO();

        dto.setId(emp.getId());
        dto.setName(emp.getName());
        dto.setEmail(emp.getEmail());
        dto.setSalary(emp.getSalary());

        return dto;
    }


    public String deleteEmployee(Long id) 
    {
        if (!employeeRepository.existsById(id)) 
        {
            throw new RuntimeException("Employee not found with id: " + id);
        }

        employeeRepository.deleteById(id);

        return "Employee deleted successfully with id: " + id;
    }
    
    
 
}