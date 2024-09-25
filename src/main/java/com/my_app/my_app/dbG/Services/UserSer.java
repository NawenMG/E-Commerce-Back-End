package com.my_app.my_app.dbG.Services;

import com.my_app.my_app.dbG.Parametri.ParamQuery;
import com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione.NodeUser;
import com.my_app.my_app.dbG.Repository.Classsss.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSer {

    @Autowired
    private UserRep userRep;

    // Ricerca dinamica degli utenti
    public List<NodeUser> findByDynamicQuery(ParamQuery paramQuery) {
        return userRep.findByDynamicQuery(paramQuery);
    }

    // Inserimento di un nuovo utente
    public void insertNodeUser(NodeUser user) {
        userRep.insertNodeUser(user);
    }

    // Aggiornamento di un utente esistente
    public void updateNodeUser(NodeUser user) {
        userRep.updateNodeUser(user);
    }

    // Eliminazione di un utente
    public void deleteNodeUser(String userId) {
        userRep.deleteNodeUser(userId);
    }
}
