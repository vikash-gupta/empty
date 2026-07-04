package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InterviewTest {
    @Test
    public void testSum(){
        var instance = new Interview();
        Assertions.assertEquals(30,instance.sum(10,20));
    }
}