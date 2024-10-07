package com.my_app.my_app.dbCol.API.Soap.ArchiviazioneSegnalazioni.Services.Interfacceeeee;

import com.my_app.my_app.dbCol.Models.ArchiviazioneSegnalazioni;
import com.my_app.my_app.dbCol.Parametri.ParamQuery;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public interface ArchiviazioneSegnalazioniServiceI {

    @WebMethod
    List<ArchiviazioneSegnalazioni> getSegnalazioni(ParamQuery paramQuery);

    @WebMethod
    void insertSegnalazione(ArchiviazioneSegnalazioni segnalazione);

    @WebMethod
    void updateSegnalazione(ArchiviazioneSegnalazioni segnalazione);

    @WebMethod
    void deleteSegnalazione(int id);
}
