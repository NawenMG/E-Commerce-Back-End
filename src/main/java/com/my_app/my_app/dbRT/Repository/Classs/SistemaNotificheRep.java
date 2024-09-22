package com.my_app.my_app.dbRT.Repository.Classs;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.my_app.my_app.dbRT.Collections.SistemaNotifiche;
import com.my_app.my_app.dbRT.Parametri.ParamQuerySistemaNotifiche;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
public class SistemaNotificheRep {

    private DatabaseReference notificheRef = FirebaseDatabase.getInstance().getReference("SistemaDiNotifiche");

    // Metodo per eseguire una query dinamica utilizzando ParamQueryChat
    public CompletableFuture<List<SistemaNotifiche>> queryChats(ParamQuerySistemaNotifiche paramQuerySistemaNotifiche ) {
        CompletableFuture<List<SistemaNotifiche>> future = new CompletableFuture<>();

        // Esegue la query dinamica e passa il callback per ricevere i risultati
        paramQuerySistemaNotifiche.executeQuery(new ParamQuerySistemaNotifiche.NotificheCallback() {
            @Override
            public void onSuccess(List<SistemaNotifiche> notificheList) {
                future.complete(notificheList);
            }

            @Override
            public void onError(Exception e) {
                future.completeExceptionally(e);
            }
        });

        return future;
    }
    
    // Metodo per inserire una nuova chat
    public void insertChat(SistemaNotifiche sistemaNotifiche) {
        String key = notificheRef.push().getKey();  
        notificheRef.child(key).setValue(sistemaNotifiche, (databaseError, databaseReference) -> {
            if (databaseError != null) {
                System.err.println("Errore durante l'inserimento della notifica: " + databaseError.getMessage());
            }
        });
    }

    // Metodo per aggiornare una chat esistente
    public void updateChat(String chatId, SistemaNotifiche sistemaNotifiche) {
        notificheRef.child(chatId).setValue(sistemaNotifiche, (databaseError, databaseReference) -> {
            if (databaseError != null) {
                System.err.println("Errore durante l'aggiornamento della notifica: " + databaseError.getMessage());
            }
        });
    }

    // Metodo per eliminare una chat tramite il suo ID
    public void deleteChat(String chatId) {
        notificheRef.child(chatId).removeValue((databaseError, databaseReference) -> {
            if (databaseError != null) {
                System.err.println("Errore durante l'eliminazione della notifica: " + databaseError.getMessage());
            }
        });
    }

}
