package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class PalindromeTest {
    private Palindrome palindrome;
    @BeforeEach
    void SetUp() {
        palindrome = new Palindrome();
    }



    @Test
    public void testIsPalindrome() {
        assertEquals(true, palindrome.isPalindrome("maram"));
    }


    @Test
    public void testIsPalindromeWithOneWord() {
        assertEquals(true, palindrome.isPalindrome("radar"));
    }


    @Test
    public void testIsPalindromeWithNonPalindromeWord() {

        assertEquals(false, palindrome.isPalindrome("abdelbasset"));
    }


    @Test
    void isPalindromeOriginal_withNullString_shouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindromeOriginal(null));
    }
}