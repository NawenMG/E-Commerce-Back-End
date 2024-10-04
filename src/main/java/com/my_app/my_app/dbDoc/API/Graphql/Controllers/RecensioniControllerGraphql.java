package com.my_app.my_app.dbDoc.API.Graphql.Controllers;

import com.my_app.my_app.dbDoc.Collections.Recensioni;
import com.my_app.my_app.dbDoc.Parametri.ParamQueryRecensioni;
import com.my_app.my_app.dbDoc.Repository.Classss.RecensioniRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class RecensioniControllerGraphql {

    @Autowired
    private RecensioniRep recensioniRep; 

    @QueryMapping
    public List<Recensioni> getRecensioni(@Argument ParamQueryRecensioni params) {
        // Esegui la query utilizzando il repository
        return recensioniRep.query(new Recensioni()); 
    }
}
