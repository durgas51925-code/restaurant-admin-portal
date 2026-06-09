package com.blaze.backend.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blaze.backend.restaurant.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>
{

}