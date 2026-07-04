package com.example.webapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String id;
    private String fullName;
    private String department;
    private BigDecimal salary;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}