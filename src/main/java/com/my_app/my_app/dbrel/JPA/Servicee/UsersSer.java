package com.my_app.my_app.dbrel.JPA.Servicee;

import com.my_app.my_app.dbrel.JPA.Entity.Users;
import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;
import com.my_app.my_app.dbrel.JPA.Repository.Classss.UsersRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersSer {

    @Autowired
    private UsersRep usersRep;

    // Query per ottenere gli utenti in base ai parametri
    public List<Users> query(ParamQueryJpa paramQuery) {
        return usersRep.query(paramQuery);
    }

    // Inserire un nuovo utente
    public void insert(Users user) {
        usersRep.insert(user);
    }

    // Aggiornare un utente esistente
    public void update(Users user) {
        usersRep.update(user);
    }

    // Eliminare un utente per ID
    public void delete(Integer id) {
        usersRep.delete(id);
    }
}
