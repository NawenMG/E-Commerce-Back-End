package com.my_app.my_app.dbCol.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my_app.my_app.dbCol.Models.ArchiviazioneTransizioni;
import com.my_app.my_app.dbCol.Parametri.ParamQuery;
import com.my_app.my_app.dbCol.Repository.Interfaceeee.ArchiviazioneTransizioniI;

@Service
public class ArchiviazioneTransizioniSer {

    @Autowired
    private ArchiviazioneTransizioniI archiviazioneTransizioniRep;

    public List<ArchiviazioneTransizioni> query(ParamQuery paramQuery) {
        return archiviazioneTransizioniRep.query(paramQuery);
    }

    public void insertOrdine(ArchiviazioneTransizioni transizioni) {
        archiviazioneTransizioniRep.insertOrdine(transizioni);
    }

    public void updateOrdine(ArchiviazioneTransizioni transizioni) {
        archiviazioneTransizioniRep.updateOrdine(transizioni);
    }

    public void deleteOrdine(int id) {
        archiviazioneTransizioniRep.deleteOrdine(id);
    }
}
