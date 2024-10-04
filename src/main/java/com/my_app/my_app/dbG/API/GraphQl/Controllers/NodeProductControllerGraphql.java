package com.my_app.my_app.dbG.API.GraphQl.Controllers;

import com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione.NodeProduct;
import com.my_app.my_app.dbG.Parametri.ParamQuery;
import com.my_app.my_app.dbG.Repository.Classsss.ProductRep; // Assicurati che questo pacchetto esista e sia corretto

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class NodeProductControllerGraphql {

    @Autowired
    private ProductRep productRep; 

    @QueryMapping
    public List<NodeProduct> getProducts(@Argument ParamQuery params) {
        return productRep.findByDynamicQuery(params); 
    }
}
