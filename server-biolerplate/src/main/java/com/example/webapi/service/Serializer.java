package com.example.webapi.service;

import com.example.webapi.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Serializer {
    private final ObjectMapper objectMapper = new ObjectMapper();

    // Serialize — Employee object to JSON string
    public String serializeEmployee(Employee employee) {
        try {
            return objectMapper.writeValueAsString(employee);
        } catch (Exception ex) {
            log.error("Failed to serialize employee: {}", ex.getMessage());
            throw new RuntimeException("Serialization failed");
        }
    }

    // Deserialize — JSON string to Employee object
    public Employee deserializeEmployee(String json) {
        try {
            return objectMapper.readValue(json, Employee.class);
        } catch (Exception ex) {
            log.error("Failed to deserialize employee: {}", ex.getMessage());
            throw new RuntimeException("Deserialization failed");
        }
    }
}
