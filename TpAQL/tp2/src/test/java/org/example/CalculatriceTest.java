package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculatriceTest {
    @Mock
    Calculatrice calc;
    @Test
    public void testAdditionner() {
        Mockito.when(calc.additionner(6, 9)).thenReturn(15);

        int result = calc.additionner (6,9);

        Assertions.assertEquals(result,15);

        Mockito.verify(calc).additionner(6,9);

        Mockito.verifyNoMoreInteractions(calc);

        int state = calc.getState();
        Mockito.verify(calc).getState();
        Mockito.when(calc.getState()).thenReturn(Integer.valueOf("1")) ;
    }
}