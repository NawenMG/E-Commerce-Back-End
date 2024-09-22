package com.my_app.my_app.dbRT.Repository.Interfaceeee;

import com.my_app.my_app.dbRT.Collections.SistemaSpedizione;
import com.my_app.my_app.dbRT.Parametri.ParamQuerySistemaSpedizione;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface SistemaSpedizioneI {

    // Metodo per eseguire una query dinamica utilizzando ParamQuerySistemaSpedizione
    CompletableFuture<List<SistemaSpedizione>> queryChats(ParamQuerySistemaSpedizione paramQuerySistemaSpedizione);

    // Metodo per inserire una nuova spedizione
    void insertChat(SistemaSpedizione sistemaSpedizione);

    // Metodo per aggiornare una spedizione esistente
    void updateChat(String spedizioneID, SistemaSpedizione sistemaSpedizione);

    // Metodo per eliminare una spedizione tramite il suo ID
    void deleteChat(String spedizioneID);
}
