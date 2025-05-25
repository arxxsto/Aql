package org.example;



import static org.junit.jupiter.api.Assertions.assertThrows;
import java.lang.reflect.Array;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BinarySearchTest {

    private BinarySearch binarySearch;
    @BeforeEach
    void SetUp() {
        binarySearch = new BinarySearch();
    }



    @Test
    void testArrayIsNULL() {
        Array a = null;
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 6));
    }

    @Test
    void testBinarySearch() {
        int[] array = {10, 20, 30, 40, 50};
        int element = 40;
        int index = BinarySearch.binarySearch(array, element);
        Assertions.assertEquals(3, index);
    }

    @Test
    void testElementNotInTheArray() {
        int[] array = {10, 20, 30, 40, 50};
        int element = 80;
        int index = BinarySearch.binarySearch(array, element);
        Assertions.assertEquals(-1, index);
    }

    @Test
    void testMidofArrayGreaterThanElement() {
        // To Rename later
        int[] array = {10, 20, 30, 40, 50};
        int element = 20;
        int index = BinarySearch.binarySearch(array, element);
        Assertions.assertEquals(1, index);
    }
}