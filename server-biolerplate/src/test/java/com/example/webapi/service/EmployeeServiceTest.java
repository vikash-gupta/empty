package com.example.webapi.service;

import com.example.webapi.entity.Employee;
import com.example.webapi.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    // @Mock creates a fake version of the dependency
    // you control what it returns — no real DB or HTTP calls
    @Mock
    private EmployeeRepository employeeRepository;

    // @InjectMocks creates the real service
    // and injects the mocks above into it
    @InjectMocks
    private EmployeeService employeeService;

    private Employee emp1;
    private Employee emp2;

    @BeforeEach
    void setUp() {
        emp1 = Employee.builder().id("1").fullName("John Smith").build();
        emp2 = Employee.builder().id("2").fullName("Jane Doe").build();
    }

    @Test
    void shouldReturnCount() {
        // ARRANGE — tell mocks what to return when called
        when(employeeRepository.findAll()).thenReturn(List.of(emp1, emp2)); // DB has 2
        
        // ACT — call the real service method
        int total = employeeService.getAll().size();

        // ASSERT — verify the result
        assertEquals(2, total);

        // VERIFY — confirm dependencies were actually called
        verify(employeeRepository, times(1)).findAll();
        
    }

    
}