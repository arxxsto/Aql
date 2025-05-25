package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    private Stack stack;
    @BeforeEach
    void Setup(){
        stack = new Stack();
    }
    @Test// la pile n'est pas pleine
    void pushShouldAddElementToTheTopOfTheStack() {
        stack.push(50);
        assertEquals(1,stack.size());
        assertEquals(50,stack.peek());
    }
    @Test
    void pushShouldExpandArrayIfStackIsFull(){
        //rempliassage de pile
        for(int i=0;i<10;i++) {
            stack.push(i*10);
        }

        assertEquals(10,stack.size());
        stack.push(70);
        assertEquals(11,stack.size());
        assertEquals(70,stack.peek());
    }
    @Test
    void popShouldReturnTheElementAtTheTopIfIsNotEmpty() {
        stack.push(50);
        assertEquals(50,stack.pop());
        assertEquals(0,stack.size());


    }
    @Test
    void popShouldRaiseExceptionIfStackIsEmpty(){
        assertThrows(IllegalStateException.class,() -> stack.pop());

    }
    @Test
    void peekShouldReturnElementAtTheTopIfStackIsNotEpmty() {

        stack.push(20);
        assertEquals(20,stack.peek());
    }
    @Test
    void peekShouldRaiseExceptionIfStackIsEmpty(){
        assertThrows(IllegalStateException.class,() ->stack.peek());
    }
    @Test
    void isEmptyShouldRrturnTrueIfItIsEmpty() {
        assertTrue(stack.isEmpty());
    }
    @Test
    void isEmptyShouldRrturnFalseIfItIsNotEmpty() {
        stack.push(89);
        assertFalse(stack.isEmpty());
    }

    @Test
    void sizeShouldReturnSizeOfStack() {
        stack.push(55);
        assertEquals(1,stack.size());
    }
}