package com.my_app.my_app.dbRT.Services;

import com.my_app.my_app.dbRT.Collections.Chat;
import com.my_app.my_app.dbRT.Parametri.ParamQueryChat;
import com.my_app.my_app.dbRT.Repository.Interfaceeee.ChatI;
import com.my_app.my_app.dbRT.Repository.Classs.ChatRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ChatSer implements ChatI {

    @Autowired
    private ChatRep chatRep;

    

    public CompletableFuture<List<Chat>> queryChats(ParamQueryChat paramQueryChat) {
        return chatRep.queryChats(paramQueryChat);
    }

    public void insertChat(Chat chat) {
        chatRep.insertChat(chat);
    }

    public void updateChat(String chatId, Chat chat) {
        chatRep.updateChat(chatId, chat);
    }

    public void deleteChat(String chatId) {
        chatRep.deleteChat(chatId);
    }
}
