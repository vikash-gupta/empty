package com.example.webapi;

import com.example.webapi.entity.Employee;
import com.example.webapi.service.Serializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SerializerTests {
    @Test
    public void Test(){
        var obj = new Serializer();
        var e = Employee.builder().fullName("Test").id("100").build();
        var serialized = obj.serializeEmployee(e);
        var deserialized = obj.deserializeEmployee(serialized);
        Assertions.assertEquals(e,deserialized);
    }
}
