package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class QuadraticEquationTest {

    private QuadraticEquation quadraticEquation;

    @BeforeEach
    void SetUp() {
        quadraticEquation = new QuadraticEquation();
    }

    @Test
    void testUsingAEqualsZero() {
        double a = 0;
        double b = 4;
        double c = 5;
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(a, b, c));
    }

    @Test
    void testUsingDeltaLessThanZero() {
        double a = 2;
        double b = 1;
        double c = 2;
        double[] res = QuadraticEquation.solve(a, b, c);
        assertNull(res);
    }

    @Test
    void testUsingDeltaEqualsZero() {
        double a = 2;
        double b = 4;
        double c = 2;
        double[] res = QuadraticEquation.solve(a, b, c);
        assertArrayEquals(new double[]{-b / (2 * a)}, res);
    }

    @Test
    void testUsingDeltaGreaterThanZero() {
        double a = 1;
        double b = 3;
        double c = 1;
        double[] res = QuadraticEquation.solve(a, b, c);
        assertArrayEquals(new double[]{(-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a), (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a)}, res);
    }


}