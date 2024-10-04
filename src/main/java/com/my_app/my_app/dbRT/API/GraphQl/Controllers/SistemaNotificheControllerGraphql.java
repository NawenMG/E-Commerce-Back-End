package com.my_app.my_app.dbRT.API.GraphQl.Controllers;

import com.my_app.my_app.dbRT.Collections.SistemaNotifiche;
import com.my_app.my_app.dbRT.Parametri.ParamQuerySistemaNotifiche;
import com.my_app.my_app.dbRT.Repository.Classs.SistemaNotificheRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Controller
public class SistemaNotificheControllerGraphql {

    @Autowired
    private SistemaNotificheRep sistemaNotificheRep;

    @QueryMapping
    public CompletableFuture<List<SistemaNotifiche>> getNotifiche(@Argument ParamQuerySistemaNotifiche params) {
        return sistemaNotificheRep.queryChats(params);
    }
}
