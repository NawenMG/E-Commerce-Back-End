package com.my_app.my_app.dbRT.Services;

import com.my_app.my_app.dbRT.Collections.SistemaSpedizione;
import com.my_app.my_app.dbRT.Parametri.ParamQuerySistemaSpedizione;
import com.my_app.my_app.dbRT.Repository.Interfaceeee.SistemaSpedizioneI;
import com.my_app.my_app.dbRT.Repository.Classs.SistemaSpedizioneRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class SistemaSpedizioneSer implements SistemaSpedizioneI {

    @Autowired
    private SistemaSpedizioneRep sistemaSpedizioneRep;

    public CompletableFuture<List<SistemaSpedizione>> queryChats(ParamQuerySistemaSpedizione paramQuerySistemaSpedizione) {
        return sistemaSpedizioneRep.queryChats(paramQuerySistemaSpedizione);
    }

    public void insertChat(SistemaSpedizione sistemaSpedizione) {
        sistemaSpedizioneRep.insertChat(sistemaSpedizione);
    }

    public void updateChat(String spedizioneID, SistemaSpedizione sistemaSpedizione) {
        sistemaSpedizioneRep.updateChat(spedizioneID, sistemaSpedizione);
    }

    public void deleteChat(String spedizioneID) {
        sistemaSpedizioneRep.deleteChat(spedizioneID);
    }
}
