package com.my_app.my_app.dbRT.Repository.Classs;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.my_app.my_app.dbRT.Collections.Chat;
import com.my_app.my_app.dbRT.Parametri.ParamQueryChat;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
public class ChatRep {

    private DatabaseReference chatRef = FirebaseDatabase.getInstance().getReference("Chat");

    // Metodo per eseguire una query dinamica utilizzando ParamQueryChat
    public CompletableFuture<List<Chat>> queryChats(ParamQueryChat paramQueryChat) {
        CompletableFuture<List<Chat>> future = new CompletableFuture<>();

        // Esegue la query dinamica e passa il callback per ricevere i risultati
        paramQueryChat.executeQuery(new ParamQueryChat.ChatCallback() {
            @Override
            public void onSuccess(List<Chat> chatList) {
                future.complete(chatList);
            }

            @Override
            public void onError(Exception e) {
                future.completeExceptionally(e);
            }
        });

        return future;
    }

    // Metodo per inserire una nuova chat
    public void insertChat(Chat chat) {
        String key = chatRef.push().getKey();  
        chatRef.child(key).setValue(chat, (databaseError, databaseReference) -> {
            if (databaseError != null) {
                System.err.println("Errore durante l'inserimento della chat: " + databaseError.getMessage());
            }
        });
    }

    // Metodo per aggiornare una chat esistente
    public void updateChat(String chatId, Chat chat) {
        chatRef.child(chatId).setValue(chat, (databaseError, databaseReference) -> {
            if (databaseError != null) {
                System.err.println("Errore durante l'aggiornamento della chat: " + databaseError.getMessage());
            }
        });
    }

    // Metodo per eliminare una chat tramite il suo ID
    public void deleteChat(String chatId) {
        chatRef.child(chatId).removeValue((databaseError, databaseReference) -> {
            if (databaseError != null) {
                System.err.println("Errore durante l'eliminazione della chat: " + databaseError.getMessage());
            }
        });
    }

}
