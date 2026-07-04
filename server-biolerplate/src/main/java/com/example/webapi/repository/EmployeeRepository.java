package com.example.webapi.repository;

import com.example.webapi.entity.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();
}
