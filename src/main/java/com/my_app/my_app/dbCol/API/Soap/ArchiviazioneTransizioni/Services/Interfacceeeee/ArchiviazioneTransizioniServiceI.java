package com.my_app.my_app.dbCol.API.Soap.ArchiviazioneTransizioni.Services.Interfacceeeee;

import com.my_app.my_app.dbCol.Models.ArchiviazioneTransizioni;
import com.my_app.my_app.dbCol.Parametri.ParamQuery;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public interface ArchiviazioneTransizioniServiceI {

    @WebMethod
    List<ArchiviazioneTransizioni> getTransizioni(ParamQuery paramQuery);

    @WebMethod
    void insertTransizione(ArchiviazioneTransizioni transizione);

    @WebMethod
    void updateTransizione(ArchiviazioneTransizioni transizione);

    @WebMethod
    void deleteTransizione(int id);
}
