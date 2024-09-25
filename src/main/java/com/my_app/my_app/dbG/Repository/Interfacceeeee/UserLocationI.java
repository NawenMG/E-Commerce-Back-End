package com.my_app.my_app.dbG.Repository.Interfacceeeee;

import com.my_app.my_app.dbG.Parametri.ParamQuery;
import com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione.NodeUserLocation;

import java.util.List;

public interface UserLocationI {

    // Ricerca dinamica delle localizzazioni utente
    List<NodeUserLocation> findByDynamicQuery(ParamQuery paramQuery);

    // Inserimento di un nuovo nodo di localizzazione utente
    void insertNodeUserLocation(NodeUserLocation location);

    // Aggiornamento di un nodo di localizzazione utente esistente
    void updateNodeUserLocation(NodeUserLocation location);

    // Eliminazione di un nodo di localizzazione utente
    void deleteNodeUserLocation(String locationId);
}
