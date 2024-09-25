package com.my_app.my_app.dbG.Services;

import com.my_app.my_app.dbG.Parametri.ParamQuery;
import com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione.NodeUserLocation;
import com.my_app.my_app.dbG.Repository.Classsss.UserLocationRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLocationSer {

    @Autowired
    private UserLocationRep userLocationRep;

    // Ricerca dinamica delle localizzazioni utente
    public List<NodeUserLocation> findByDynamicQuery(ParamQuery paramQuery) {
        return userLocationRep.findByDynamicQuery(paramQuery);
    }

    // Inserimento di una nuova localizzazione utente
    public void insertNodeUserLocation(NodeUserLocation location) {
        userLocationRep.insertNodeUserLocation(location);
    }

    // Aggiornamento di una localizzazione utente esistente
    public void updateNodeUserLocation(NodeUserLocation location) {
        userLocationRep.updateNodeUserLocation(location);
    }

    // Eliminazione di una localizzazione utente
    public void deleteNodeUserLocation(String locationId) {
        userLocationRep.deleteNodeUserLocation(locationId);
    }
}
