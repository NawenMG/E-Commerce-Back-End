package com.my_app.my_app.dbRT.Services;

import com.my_app.my_app.dbRT.Collections.Chat;
import com.my_app.my_app.dbRT.Parametri.ParamQueryChat;
import com.my_app.my_app.dbRT.Repository.Interfaceeee.ChatI;
import com.my_app.my_app.dbRT.Repository.Classs.ChatRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ChatSer implements ChatI {

    @Autowired
    private ChatRep chatRep;

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public CompletableFuture<List<Chat>> queryChats(ParamQueryChat paramQueryChat) {
        return chatRep.queryChats(paramQueryChat);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void insertChat(Chat chat) {
        chatRep.insertChat(chat);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void updateChat(String chatId, Chat chat) {
        chatRep.updateChat(chatId, chat);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void deleteChat(String chatId) {
        chatRep.deleteChat(chatId);
    }
}
