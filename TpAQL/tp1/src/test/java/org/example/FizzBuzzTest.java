package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class FizzBuzzTest {
    private FizzBuzz fizzBuzzTest;


    @BeforeEach
    void SetUp() {
        fizzBuzzTest = new FizzBuzz();
    }

    @Test
    public void testNegative() {

        assertThrows(IllegalArgumentException.class, () -> fizzBuzzTest.fizzBuzz(-1));
    }


    @Test
    public void testMultiple3() {

        assertEquals("Fizz", fizzBuzzTest.fizzBuzz(9));
    }

    @Test
    public void testMultiple5() {

        assertEquals("Buzz", fizzBuzzTest.fizzBuzz(25));
    }

    @Test
    public void testMultiple3andMultiple5() {

        assertEquals("FizzBuzz", fizzBuzzTest.fizzBuzz(45));
    }

    @Test
    public void testNotAnyMultiple() {

        assertEquals("22", fizzBuzzTest.fizzBuzz(22));
    }
}