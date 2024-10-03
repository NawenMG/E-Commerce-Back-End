package com.my_app.my_app.dbRT.API.RestFul.Controllers;

import com.my_app.my_app.dbRT.Collections.Chat;
import com.my_app.my_app.dbRT.Parametri.ParamQueryChat;
import com.my_app.my_app.dbRT.Services.ChatSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/rt/chats")
@PreAuthorize("hasRole('USER')")
public class MyControllerChat {

    @Autowired
    private ChatSer chatSer;

    // Endpoint per eseguire una query dinamica sulle chat
    @GetMapping("/query")
    public CompletableFuture<ResponseEntity<List<Chat>>> queryChats(@RequestBody ParamQueryChat paramQueryChat) {
        return chatSer.queryChats(paramQueryChat)
            .thenApply(notificheList -> new ResponseEntity<>(notificheList, HttpStatus.OK))
            .exceptionally(ex -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    // Endpoint per inserire una nuova chat
    @PostMapping
    public ResponseEntity<Void> insertChat(@RequestBody Chat chat) {
        chatSer.insertChat(chat);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Endpoint per aggiornare una chat esistente
    @PutMapping("/{chatId}")
    public ResponseEntity<Void> updateChat(@PathVariable String chatId, @RequestBody Chat chat) {
        chatSer.updateChat(chatId, chat);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Endpoint per eliminare una chat tramite il suo ID
    @DeleteMapping("/{chatId}")
    public ResponseEntity<Void> deleteChat(@PathVariable String chatId) {
        chatSer.deleteChat(chatId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
