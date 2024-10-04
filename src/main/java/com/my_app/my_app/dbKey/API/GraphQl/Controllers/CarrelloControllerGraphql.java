package com.my_app.my_app.dbKey.API.GraphQl.Controllers;

import com.my_app.my_app.dbKey.Models.Carrello;
import com.my_app.my_app.dbKey.Parametri.ParamQuery;
import com.my_app.my_app.dbKey.Repository.Classss.CarrelloRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CarrelloControllerGraphql {
    
    @Autowired
    private CarrelloRep carrelloRep;    

    @QueryMapping
    public List<Carrello> getCarrelli(@Argument ParamQuery params) {
        return carrelloRep.search(params);
    }
}
