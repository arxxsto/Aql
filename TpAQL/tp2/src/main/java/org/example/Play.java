package org.example;

import java.util.Random;

public class Play implements Joueur {
    public int argent ;

    public Play(int arg){
        this.argent = arg ;
    }
    @Override
    public int mise() {
        return new Random().nextInt(1,argent+1);
    }

    @Override
    public void debiter(int somme) throws DebitImpossibleException {
        if(somme < argent){
            this.argent = this.argent - somme ;
        }else {
            throw new DebitImpossibleException("impossible de debiter cette somme") ;
        }
    }

    @Override
    public void crediter(int somme) {
        this.argent = this.argent +  somme ;
    }

    public int getArgent() {
        return argent;
    }
}
