package com.my_app.my_app.dbKey.API.GraphQl.Controllers;

import com.my_app.my_app.dbKey.Models.Cronologia;
import com.my_app.my_app.dbKey.Parametri.ParamQuery;
import com.my_app.my_app.dbKey.Repository.Classss.CronologiaRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CronologiaControllerGraphql {
    
    @Autowired
    private CronologiaRep cronologiaRep;    

    @QueryMapping
    public List<Cronologia> getCronologie(@Argument ParamQuery params) {
        return cronologiaRep.search(params);
    }
}
