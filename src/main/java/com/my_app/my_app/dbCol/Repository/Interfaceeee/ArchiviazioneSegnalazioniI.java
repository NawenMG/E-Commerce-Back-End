package com.my_app.my_app.dbCol.Repository.Interfaceeee;

import java.util.List;

import com.my_app.my_app.dbCol.Models.ArchiviazioneSegnalazioni;
import com.my_app.my_app.dbCol.Parametri.ParamQuery;

public interface ArchiviazioneSegnalazioniI {

    List<ArchiviazioneSegnalazioni> query(ParamQuery paramQuery);

    void insertOrdine(ArchiviazioneSegnalazioni segnalazioni);

    void updateOrdine(ArchiviazioneSegnalazioni segnalazioni);

    void deleteOrdine(int id);
}
