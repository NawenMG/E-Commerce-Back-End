package com.my_app.my_app.dbRT.Services;

import com.my_app.my_app.dbRT.Collections.SistemaNotifiche;
import com.my_app.my_app.dbRT.Parametri.ParamQuerySistemaNotifiche;
import com.my_app.my_app.dbRT.Repository.Interfaceeee.SistemaNotificheI;
import com.my_app.my_app.dbRT.Repository.Classs.SistemaNotificheRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class SistemaNotificheSer implements SistemaNotificheI {

    @Autowired
    private SistemaNotificheRep sistemaNotificheRep;

    public CompletableFuture<List<SistemaNotifiche>> queryChats(ParamQuerySistemaNotifiche paramQuerySistemaNotifiche) {
        return sistemaNotificheRep.queryChats(paramQuerySistemaNotifiche);
    }

    public void insertChat(SistemaNotifiche sistemaNotifiche) {
        sistemaNotificheRep.insertChat(sistemaNotifiche);
    }

    public void updateChat(String chatId, SistemaNotifiche sistemaNotifiche) {
        sistemaNotificheRep.updateChat(chatId, sistemaNotifiche);
    }

    public void deleteChat(String chatId) {
        sistemaNotificheRep.deleteChat(chatId);
    }
}
