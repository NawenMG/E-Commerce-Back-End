package com.my_app.my_app.dbCol.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my_app.my_app.dbCol.Models.ArchiviazioneOrdini;
import com.my_app.my_app.dbCol.Parametri.ParamQuery;
import com.my_app.my_app.dbCol.Repository.Interfaceeee.ArchiviazioneOrdiniI;

@Service
public class ArhciviazioneOrdiniSer {

    @Autowired
    private ArchiviazioneOrdiniI archiviazioneOrdiniRep;

    public List<ArchiviazioneOrdini> query(ParamQuery paramQuery) {
        return archiviazioneOrdiniRep.query(paramQuery);
    }

    public void insertOrdine(ArchiviazioneOrdini ordine) {
        archiviazioneOrdiniRep.insertOrdine(ordine);
    }

    public void updateOrdine(ArchiviazioneOrdini ordine) {
        archiviazioneOrdiniRep.updateOrdine(ordine);
    }

    public void deleteOrdine(int id) {
        archiviazioneOrdiniRep.deleteOrdine(id);
    }
}
