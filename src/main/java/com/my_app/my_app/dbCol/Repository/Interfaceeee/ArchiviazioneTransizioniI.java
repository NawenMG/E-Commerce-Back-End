package com.my_app.my_app.dbCol.Repository.Interfaceeee;

import java.util.List;

import com.my_app.my_app.dbCol.Models.ArchiviazioneTransizioni;
import com.my_app.my_app.dbCol.Parametri.ParamQuery;

public interface ArchiviazioneTransizioniI {

    List<ArchiviazioneTransizioni> query(ParamQuery paramQuery);

    void insertOrdine(ArchiviazioneTransizioni transizioni);

    void updateOrdine(ArchiviazioneTransizioni transizioni);

    void deleteOrdine(int id);
}
