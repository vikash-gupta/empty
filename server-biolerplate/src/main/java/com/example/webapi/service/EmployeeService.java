package com.example.webapi.service;

import com.example.webapi.entity.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.webapi.repository.EmployeeRepository;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final AtomicInteger counter = new AtomicInteger(1);
    private final Map<String, Employee> store = new HashMap<>();

    private final EmployeeRepository employeeRepository;       // simulates DB
    
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getById(String id) {
        return store.get(id);
    }

    public Employee create(Employee request) {
        String id = String.valueOf(counter.getAndIncrement());
        Employee employee = Employee.builder()
                .id(UUID.randomUUID().toString())
                .fullName(request.getFullName())
                .department(request.getDepartment())
                .salary(request.getSalary())
                .status("active")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        store.put(employee.getId(), employee);
        log.info("Created employee: {}", employee.getId());
        return employee;
    }

    public Employee update(String id, Employee request) {
        Employee existing = store.get(id);
        if (existing == null) return null;
        existing.setFullName(request.getFullName());
        existing.setDepartment(request.getDepartment());
        existing.setSalary(request.getSalary());
        existing.setStatus(request.getStatus());
        existing.setUpdatedAt(LocalDateTime.now());
        store.put(id, existing);
        return existing;
    }

    public boolean delete(String id) {
        return store.remove(id) != null;
    }

//    public int getTotalEmployeeCount() {
//        int dbCount = employeeRepository.findAll().size();
//        int externalCount = externalPayrollService.getEmployeeCount();
//        return dbCount + externalCount;
//    }
}