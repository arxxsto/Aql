package org.example;

public interface JeuInterface {
    public void jouer(Joueur j, De d1, De de2) throws JeuFermeException;
    public void fermer();
    public boolean estOuvert();
}
