package com.my_app.my_app.dbCol.Repository.Interfaceeee;

import java.util.List;

import com.my_app.my_app.dbCol.Models.ArchiviazioneOrdini;
import com.my_app.my_app.dbCol.Parametri.ParamQuery;

public interface ArchiviazioneOrdiniI {

    List<ArchiviazioneOrdini> query(ParamQuery paramQuery);

    void insertOrdine(ArchiviazioneOrdini ordine);

    void updateOrdine(ArchiviazioneOrdini ordine);

    void deleteOrdine(int id);
}
