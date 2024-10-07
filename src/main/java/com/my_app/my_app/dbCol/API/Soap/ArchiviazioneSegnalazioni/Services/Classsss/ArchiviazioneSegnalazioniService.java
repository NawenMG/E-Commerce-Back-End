package com.my_app.my_app.dbCol.API.Soap.ArchiviazioneSegnalazioni.Services.Classsss;

import com.my_app.my_app.dbCol.API.Soap.ArchiviazioneSegnalazioni.Services.Interfacceeeee.ArchiviazioneSegnalazioniServiceI;
import com.my_app.my_app.dbCol.Models.ArchiviazioneSegnalazioni;
import com.my_app.my_app.dbCol.Parametri.ParamQuery;
import com.my_app.my_app.dbCol.Repository.Classsss.ArchiviazioneSegnalazioniRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.jws.WebService;
import java.util.List;

@Service
@WebService(endpointInterface = "com.my_app.my_app.dbCol.API.Soap.ArchiviazioneSegnalazioni.Services.Interfacceeeee") //Inserisci il percorso dell'interfaccia
public class ArchiviazioneSegnalazioniService implements ArchiviazioneSegnalazioniServiceI {

    @Autowired
    private ArchiviazioneSegnalazioniRep segnalazioniRep;
 
    //Soliti 4 metodi
    public List<ArchiviazioneSegnalazioni> getSegnalazioni(ParamQuery paramQuery) {
        return segnalazioniRep.query(paramQuery);
    }

    public void insertSegnalazione(ArchiviazioneSegnalazioni segnalazione) {
        segnalazioniRep.insertOrdine(segnalazione);
    }

    public void updateSegnalazione(ArchiviazioneSegnalazioni segnalazione) {
        segnalazioniRep.updateOrdine(segnalazione);
    }

    public void deleteSegnalazione(int id) {
        segnalazioniRep.deleteOrdine(id);
    }
}
