package com.my_app.my_app.dbCol.API.GraphQl.Controllers;

import com.my_app.my_app.dbCol.Models.ArchiviazioneOrdini;
import com.my_app.my_app.dbCol.Parametri.ParamQuery;
import com.my_app.my_app.dbCol.Repository.Classsss.ArchiviazioneOrdiniRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ArchiviazioneOrdiniControllerGraphql {
    
    @Autowired
    private  ArchiviazioneOrdiniRep archiviazioneOrdiniRep;    

    @QueryMapping
    @PreAuthorize("hasRole('DELIVERY')")
    public List<ArchiviazioneOrdini> getOrdini(@Argument ParamQuery params) {
        return archiviazioneOrdiniRep.query(params);
    }
}
