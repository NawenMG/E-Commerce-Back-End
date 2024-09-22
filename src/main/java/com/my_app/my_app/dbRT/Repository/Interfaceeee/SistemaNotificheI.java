package com.my_app.my_app.dbRT.Repository.Interfaceeee;

import com.my_app.my_app.dbRT.Collections.SistemaNotifiche;
import com.my_app.my_app.dbRT.Parametri.ParamQuerySistemaNotifiche;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface SistemaNotificheI {

    // Metodo per eseguire una query dinamica utilizzando ParamQuerySistemaNotifiche
    CompletableFuture<List<SistemaNotifiche>> queryChats(ParamQuerySistemaNotifiche paramQuerySistemaNotifiche);

    // Metodo per inserire una nuova notifica
    void insertChat(SistemaNotifiche sistemaNotifiche);

    // Metodo per aggiornare una notifica esistente
    void updateChat(String chatId, SistemaNotifiche sistemaNotifiche);

    // Metodo per eliminare una notifica tramite il suo ID
    void deleteChat(String chatId);
}
