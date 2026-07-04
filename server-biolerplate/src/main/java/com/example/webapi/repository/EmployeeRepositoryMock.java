package com.example.webapi.repository;

import com.example.webapi.entity.Employee;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeRepositoryMock implements EmployeeRepository{
    @Override
    public List<Employee> findAll() {
        return List.of(
            Employee.builder().id("1").fullName("John Smith").build(),
            Employee.builder().id("2").fullName("Jane Doe").build()
        );
    }
}
