package com.my_app.my_app.dbrel.JPA.Servicee;

import com.my_app.my_app.dbrel.JPA.Entity.Returns;
import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;
import com.my_app.my_app.dbrel.JPA.Repository.Classss.ReturnsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnsSer {

    @Autowired
    private ReturnsRep returnsRep;

    // Query per ottenere i dati in base ai parametri
    public List<Returns> query(ParamQueryJpa paramQuery) {
        return returnsRep.query(paramQuery);
    }

    // Inserire un nuovo ritorno
    public void insert(Returns returns) {
        returnsRep.insert(returns);
    }

    // Aggiornare un ritorno esistente
    public void update(Returns returns) {
        returnsRep.update(returns);
    }

    // Eliminare un ritorno per ID
    public void delete(Integer id) {
        returnsRep.delete(id);
    }
}
