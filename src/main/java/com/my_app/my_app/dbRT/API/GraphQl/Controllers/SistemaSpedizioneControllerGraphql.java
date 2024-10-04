package com.my_app.my_app.dbRT.API.GraphQl.Controllers;

import com.my_app.my_app.dbRT.Collections.SistemaSpedizione;
import com.my_app.my_app.dbRT.Parametri.ParamQuerySistemaSpedizione;
import com.my_app.my_app.dbRT.Repository.Classs.SistemaSpedizioneRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Controller
public class SistemaSpedizioneControllerGraphql {

    @Autowired
    private SistemaSpedizioneRep sistemaSpedizioneRep;

    @QueryMapping
    public CompletableFuture<List<SistemaSpedizione>> getSpedizioni(@Argument ParamQuerySistemaSpedizione params) {
        return sistemaSpedizioneRep.queryChats(params);
    }
}
