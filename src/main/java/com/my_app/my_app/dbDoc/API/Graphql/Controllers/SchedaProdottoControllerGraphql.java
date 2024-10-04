package com.my_app.my_app.dbDoc.API.Graphql.Controllers;

import com.my_app.my_app.dbDoc.Collections.SchedaProdotto;
import com.my_app.my_app.dbDoc.Parametri.ParamQuerySchedaProdotto; 
import com.my_app.my_app.dbDoc.Repository.Classss.SchedaProdottoRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SchedaProdottoControllerGraphql {

    @Autowired
    private SchedaProdottoRep prodottoRep; 

    @QueryMapping
    public List<SchedaProdotto> getRecensioni(@Argument ParamQuerySchedaProdotto params) {

        return prodottoRep.query(new SchedaProdotto()); 
    }
}
