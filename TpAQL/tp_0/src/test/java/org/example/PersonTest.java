package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test

    void getFullNameShouldeReturnFirstNameAndLastName() {
            Person person = new Person("ghirai","abdelbasset",18);
            assertEquals(person.getFullName(),"ghirai abdelbasset");

    }

    @Test
    void isAdultShouldReturnTrueIfAgeIsGreaterThanOrEqual18FalseIfAgeIsLessThan18() {
        Person person = new Person("ghirai","abdelbasset",18);
        assertEquals(person.isAdult(),true);

    }
}