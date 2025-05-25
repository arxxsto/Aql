package org.example;

public class Calculatrice {
    private int state=1;

    public int getState() {
        return state;
    }

    public int additionner(int a, int b) {
        int result = a + b ;
        return result;
    }
}
