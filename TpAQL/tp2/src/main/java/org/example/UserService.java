package org.example;

import java.util.Random;

public class UserService {
    private final UserApi UserApi;
    public UserService(UserApi UserApi) {
        this.UserApi = UserApi;
    }
    public int creerUser(User User) throws ServiceException {
        if(User.Prenom == null) {
            throw new ServiceException("Echec de la création de l'User");
        }
        if(User.Nom == null) {
            throw new ServiceException("Echec de la création de l'User");
        }
        if(User.Adresse == null) {
            throw new ServiceException("Echec de la création de l'User");
        }

        UserApi.creerUser(User);

        int nb = new Random().nextInt(201);
        return  nb;
    }
}
