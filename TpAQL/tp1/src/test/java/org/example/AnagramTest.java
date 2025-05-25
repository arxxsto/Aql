package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AnagramTest {
    private Anagram anagram;
    @BeforeEach
    void SetUp() {
        anagram = new Anagram();
    }


    @Test
    public void testIsAnagram() {
        assertEquals(true, anagram.isAnagram("hello", "hello"));
    }

    @Test
    public void testNotTheSameLength() {
        assertFalse(anagram.isAnagram("hello", "hi"));
    }

    @Test
    void testBothNULL() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, null));
    }

    @Test
    void testFirstIsNULL() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "basset"));
    }

    @Test
    void testSecondIsNULL() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("basset", null));
    }

    @Test
    public void testNotAnagram() {
        assertFalse(anagram.isAnagram("abcdef", "abcddddddd"));
    }

}