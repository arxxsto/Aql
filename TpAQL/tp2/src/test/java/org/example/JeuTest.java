package org.example;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class JeuTest {
    @Test
    void jouer() {
        Banqu banque = mock(Banqu.class);
        when(banque.est_solvable()).thenReturn(false);
        Play joueur = mock(Play.class) ;
        De de = new De() {
            @Override
            public int lancer() {
                return  new Random().nextInt(0,7);
            }
        };
        Jeu JeuCarte = new Jeu( banque ) ;
        JeuCarte.fermer();
        assertThrows(JeuFermeException.class, () -> {
            JeuCarte.jouer(joueur , de , de);
        });


        JeuCarte.etat_jeu = true ;
        when(joueur.mise()).thenReturn(30000);
        try {
            JeuCarte.jouer(joueur , de , de);
        } catch (JeuFermeException e) {
            throw new RuntimeException(e);
        }
        assertEquals(false ,  JeuCarte.estOuvert() );

        De detriche1 = new De() {
            @Override
            public int lancer() {
                return 3;
            }
        };
        De detriche2 = new De() {
            @Override
            public int lancer() {
                return 4;
            }
        };

        Banqu banque2 = mock(Banqu.class);
        when(banque2.est_solvable()).thenReturn(true);

        Jeu Jeu = new Jeu(banque2);

        Joueur joeurMock = mock(Joueur.class) ;
        when(joeurMock.mise()).thenReturn(3000);

        try {
            Jeu.jouer(joeurMock , detriche1 , detriche2);
            verify(joeurMock).crediter(anyInt());
        } catch (JeuFermeException e) {
            throw new RuntimeException(e);
        }

        try {
            Jeu.jouer(joueur , detriche1 , detriche1);
            verify(banque2).crediter(anyInt());
        } catch (JeuFermeException e) {
            throw new RuntimeException(e);
        }

    }

}
