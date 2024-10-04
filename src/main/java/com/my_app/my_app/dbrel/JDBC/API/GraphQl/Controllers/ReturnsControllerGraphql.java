package com.my_app.my_app.dbrel.JDBC.API.GraphQl.Controllers;

import com.my_app.my_app.dbrel.JDBC.model.Returns; 
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryReturns;
import com.my_app.my_app.dbrel.JDBC.repository.classs.ReturnsRep; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ReturnsControllerGraphql {

    @Autowired
    private ReturnsRep returnsRep; 

    @QueryMapping
    public List<Returns> getReturns(@Argument ParmQueryReturns params) {
        return returnsRep.query(params); 
    }
}
