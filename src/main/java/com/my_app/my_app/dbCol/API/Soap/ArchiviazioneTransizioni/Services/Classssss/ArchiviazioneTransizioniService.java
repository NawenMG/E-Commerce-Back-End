package com.my_app.my_app.dbCol.API.Soap.ArchiviazioneTransizioni.Services.Classssss;

import com.my_app.my_app.dbCol.Models.ArchiviazioneTransizioni;
import com.my_app.my_app.dbCol.Parametri.ParamQuery;
import com.my_app.my_app.dbCol.Repository.Classsss.ArchiviazioneTransizioniRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import jakarta.jws.WebService;
import java.util.List;

@Service
@WebService(endpointInterface = "com.my_app.my_app.dbCol.API.Soap.ArchiviazioneTransizioni.Services.Interfacceeeee.ArchiviazioneTransizioniServiceI")
public class ArchiviazioneTransizioniService implements com.my_app.my_app.dbCol.API.Soap.ArchiviazioneTransizioni.Services.Interfacceeeee.ArchiviazioneTransizioniServiceI {

    @Autowired
    private ArchiviazioneTransizioniRep transizioniRep;
    
    @PreAuthorize("hasRole('PAYMENTMAN')")
    public List<ArchiviazioneTransizioni> getTransizioni(ParamQuery paramQuery) {
        return transizioniRep.query(paramQuery);
    }

    public void insertTransizione(ArchiviazioneTransizioni transizione) {
        transizioniRep.insertOrdine(transizione);
    }

    public void updateTransizione(ArchiviazioneTransizioni transizione) {
        transizioniRep.updateOrdine(transizione);
    }

    @PreAuthorize("hasRole('PAYMENTMAN')")
    public void deleteTransizione(int id) {
        transizioniRep.deleteOrdine(id);
    }
}
