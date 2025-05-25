package org.example;

public interface Banque {
    public void crediter(int som);
    public boolean est_solvable();
    public void debiter(int som);
}
