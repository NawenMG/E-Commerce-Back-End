package com.my_app.my_app.dbTS.Repository.Interfaceeee;

import com.my_app.my_app.dbTS.Models.AnalysisUser;
import com.my_app.my_app.dbTS.Parametri.ParamQuery;

import java.util.List;

public interface AnalysisUserI {

    // Metodo per eseguire una query e ottenere una lista di AnalysisUser
    List<AnalysisUser> query(ParamQuery paramQuery);

    // Metodo per inserire un'analisi dell'utente
    void insertUser(AnalysisUser analysisUser);

    // Metodo per eliminare i dati
    void deleteData(String measurement, String user, long startTime, long endTime);
}
