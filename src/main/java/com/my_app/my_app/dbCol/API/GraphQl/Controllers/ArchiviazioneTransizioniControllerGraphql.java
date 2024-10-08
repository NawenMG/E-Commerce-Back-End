package com.my_app.my_app.dbCol.API.GraphQl.Controllers;

import com.my_app.my_app.dbCol.Models.ArchiviazioneTransizioni;
import com.my_app.my_app.dbCol.Parametri.ParamQuery;
import com.my_app.my_app.dbCol.Repository.Classsss.ArchiviazioneTransizioniRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ArchiviazioneTransizioniControllerGraphql {
    
    @Autowired
    private ArchiviazioneTransizioniRep archiviazioneTransizioniRep;

    @QueryMapping
    @PreAuthorize("hasRole('PAYMENTMAN')")
    public List<ArchiviazioneTransizioni> getTransizioni(@Argument ParamQuery params) {
        return archiviazioneTransizioniRep.query(params);
    }
}
