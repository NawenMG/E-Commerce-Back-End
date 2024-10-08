package com.my_app.my_app.dbCol.API.GraphQl.Controllers;

import com.my_app.my_app.dbCol.Models.ArchiviazioneSegnalazioni;
import com.my_app.my_app.dbCol.Parametri.ParamQuery;
import com.my_app.my_app.dbCol.Repository.Classsss.ArchiviazioneSegnalazioniRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ArchiviazioneSegnalazioniControllerGraphql {

    @Autowired
    private ArchiviazioneSegnalazioniRep archiviazioneSegnalazioniRep;    

    @QueryMapping
    @PreAuthorize("hasRole('ADMIN', 'CONTROLLER')")
    public List<ArchiviazioneSegnalazioni> getSegnalazioni(@Argument ParamQuery params) {
        return archiviazioneSegnalazioniRep.query(params);
    }
}
