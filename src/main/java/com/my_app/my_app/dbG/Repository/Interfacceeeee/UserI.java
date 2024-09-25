package com.my_app.my_app.dbG.Repository.Interfacceeeee;

import com.my_app.my_app.dbG.Parametri.ParamQuery;
import com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione.NodeUser;

import java.util.List;

public interface UserI {

    // Ricerca dinamica degli utenti
    List<NodeUser> findByDynamicQuery(ParamQuery paramQuery);

    // Inserimento di un nuovo nodo utente
    void insertNodeUser(NodeUser user);

    // Aggiornamento di un nodo utente esistente
    void updateNodeUser(NodeUser user);

    // Eliminazione di un nodo utente
    void deleteNodeUser(String userId);
}
