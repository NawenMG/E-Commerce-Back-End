package com.my_app.my_app.dbRT.Repository.Interfaceeee;

import com.my_app.my_app.dbRT.Collections.Chat;
import com.my_app.my_app.dbRT.Parametri.ParamQueryChat;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ChatI {

    // Metodo per eseguire una query dinamica utilizzando ParamQueryChat
    CompletableFuture<List<Chat>> queryChats(ParamQueryChat paramQueryChat);

    // Metodo per inserire una nuova chat
    void insertChat(Chat chat);

    // Metodo per aggiornare una chat esistente
    void updateChat(String chatId, Chat chat);

    // Metodo per eliminare una chat tramite il suo ID
    void deleteChat(String chatId);
}
