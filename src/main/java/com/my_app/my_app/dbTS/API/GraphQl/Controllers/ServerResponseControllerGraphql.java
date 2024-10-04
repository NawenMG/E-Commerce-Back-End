package com.my_app.my_app.dbTS.API.GraphQl.Controllers;

import com.my_app.my_app.dbTS.Models.ServerResponse;
import com.my_app.my_app.dbTS.Parametri.ParamQuery;
import com.my_app.my_app.dbTS.Repository.Classss.ServerResponseRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ServerResponseControllerGraphql {

    @Autowired
    private ServerResponseRep serverResponseRep;

    @QueryMapping
    public List<ServerResponse> getServerResponseData(@Argument ParamQuery params) {
        
        return serverResponseRep.query(params);
    }
}
