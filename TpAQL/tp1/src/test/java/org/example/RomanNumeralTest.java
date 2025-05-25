package org.example;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class RomanNumeralTest {
    private RomanNumeral romanNumeral;

    @BeforeEach
    void SetUp() {
        romanNumeral = new RomanNumeral();
    }

    @Test
    void testRomanNumeralGreaterThan3999() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(50000));
    }

    @Test
    void testRomanNumeralLessThan1() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(-255));
    }

    @Test
    void testRomanNumeralTen() {
        String expected = "X";
        String returned = RomanNumeral.toRoman(10);
        assertEquals(expected, returned);
    }

    @Test
    void testRomanNumeralNine() {
        String expected = "IX";
        String returned = RomanNumeral.toRoman(9);
        assertEquals(expected, returned);
    }

    @Test
    void testRomanNumeralEight() {
        String expected = "VIII";
        String returned = RomanNumeral.toRoman(8);
        assertEquals(expected, returned);
    }

    @Test
    void testRomanNumeralFourteen() {
        String expected = "XIV";
        String returned = RomanNumeral.toRoman(14);
        assertEquals(expected, returned);
    }

}