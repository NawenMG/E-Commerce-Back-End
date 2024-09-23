package com.my_app.my_app.dbCol.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my_app.my_app.dbCol.Models.ArchiviazioneSegnalazioni;
import com.my_app.my_app.dbCol.Parametri.ParamQuery;
import com.my_app.my_app.dbCol.Repository.Interfaceeee.ArchiviazioneSegnalazioniI;

@Service
public class ArchiviazioneSegnalazioniSer {

    @Autowired
    private ArchiviazioneSegnalazioniI archiviazioneSegnalazioniRep;

    public List<ArchiviazioneSegnalazioni> query(ParamQuery paramQuery) {
        return archiviazioneSegnalazioniRep.query(paramQuery);
    }

    public void insertOrdine(ArchiviazioneSegnalazioni segnalazioni) {
        archiviazioneSegnalazioniRep.insertOrdine(segnalazioni);
    }

    public void updateOrdine(ArchiviazioneSegnalazioni segnalazioni) {
        archiviazioneSegnalazioniRep.updateOrdine(segnalazioni);
    }

    public void deleteOrdine(int id) {
        archiviazioneSegnalazioniRep.deleteOrdine(id);
    }
}
