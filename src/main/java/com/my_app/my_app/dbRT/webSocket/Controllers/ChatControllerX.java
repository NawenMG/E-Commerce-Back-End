package com.my_app.my_app.dbRT.webSocket.Controllers;

import com.my_app.my_app.dbRT.webSocket.Collections.Conversazione;
import com.my_app.my_app.dbRT.webSocket.Collections.MessaggioX;
import com.my_app.my_app.dbRT.webSocket.Collections.User;
import com.my_app.my_app.dbRT.webSocket.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.List;

@Controller
public class ChatControllerX {
    
    @Autowired
    private ChatSer chatSer;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    

    // Metodo per gestire l'invio di un messaggio
    @MessageMapping("/send/message") // Mappatura del messaggio ricevuto
    @SendTo("/topic/messages") // Invia il messaggio a tutti gli utenti connessi a questo topic
    public void sendMessage(MessaggioX messaggio, Principal principal) {
        // Aggiungi l'ID del mittente al messaggio
        messaggio.setMittente(principal.getName());

        // Salva il messaggio nella conversazione
        String conversazioneID = messaggio.getDestinatario(); // Presupponendo che il destinatario sia l'ID della conversazione
        chatSer.addMessageToConversation(conversazioneID, messaggio);

        // Invia il messaggio a tutti gli utenti connessi
        messagingTemplate.convertAndSend("/topic/messages", messaggio);
    }

    // Metodo per ottenere una conversazione per ID
    @MessageMapping("/conversation/{id}")
    @SendTo("/topic/conversation") // Invia la conversazione a tutti gli utenti connessi
    public Conversazione getConversation(String conversazioneID) {
        return chatSer.getConversation(conversazioneID);
    }

    // Metodo per ottenere i messaggi di una conversazione
    @MessageMapping("/messages/{conversazioneID}")
    @SendTo("/topic/messages") // Invia i messaggi a tutti gli utenti connessi
    public List<MessaggioX> getMessages(String conversazioneID) {
        return chatSer.getMessages(conversazioneID);
    }

    // Metodo per ottenere gli utenti di una conversazione
    @MessageMapping("/users/{conversazioneID}")
    @SendTo("/topic/users") // Invia gli utenti a tutti gli utenti connessi
    public List<User> getUsers(String conversazioneID) {
        return chatSer.getConversationUsers(conversazioneID);
    }
}
