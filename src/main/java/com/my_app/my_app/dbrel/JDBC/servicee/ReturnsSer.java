package com.my_app.my_app.dbrel.JDBC.servicee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.my_app.my_app.dbrel.JDBC.Factories.Random.ReturnsFaker;
import com.my_app.my_app.dbrel.JDBC.model.Returns;
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryReturns;
import com.my_app.my_app.dbrel.JDBC.repository.interfacee.ReturnsRepI;

@Service
public class ReturnsSer {

    @Autowired
    private ReturnsRepI returnsRepI;

    // Query
    public List<Returns> queryService(ParmQueryReturns parmQuery) {
        return returnsRepI.query(parmQuery);
    }

    // Servizio per il faker
    public void saveAllService(int numberOfReturns) {
        List<Returns> returns = ReturnsFaker.createReturns(numberOfReturns);
        returnsRepI.saveAll(returns);
    }

    // Inserisci un nuovo reso
    public void insertReturnService(Returns returns) {
        returnsRepI.insertReturn(returns);
    }

    // Aggiorna un reso esistente
    public void updateReturnService(Returns returns) {
        returnsRepI.updateReturn(returns);
    }

    // Elimina un reso
    public void deleteReturnService(int returnsID) {
        returnsRepI.deleteReturn(returnsID);
    }
}
