package com.my_app.my_app.dbRT.Repository.Classs;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.my_app.my_app.dbRT.Collections.SistemaSpedizione;
import com.my_app.my_app.dbRT.Parametri.ParamQuerySistemaSpedizione;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
public class SistemaSpedizioneRep {

    private DatabaseReference notificheRef = FirebaseDatabase.getInstance().getReference("SistemaDiSpedizione");

    // Metodo per eseguire una query dinamica utilizzando ParamQueryChat
    public CompletableFuture<List<SistemaSpedizione>> queryChats(ParamQuerySistemaSpedizione paramQuerySistemaSpedizione ) {
        CompletableFuture<List<SistemaSpedizione>> future = new CompletableFuture<>();

        // Esegue la query dinamica e passa il callback per ricevere i risultati
        paramQuerySistemaSpedizione.executeQuery(new ParamQuerySistemaSpedizione.SpedizioneCallback() {
            @Override
            public void onSuccess(List<SistemaSpedizione> spedizioneList) {
                future.complete(spedizioneList);
            }

            @Override
            public void onError(Exception e) {
                future.completeExceptionally(e);
            }
        });

        return future;
    }
    
    // Metodo per inserire una nuova chat
    public void insertChat(SistemaSpedizione sistemaSpedizione) {
        String key = notificheRef.push().getKey();  
        notificheRef.child(key).setValue(sistemaSpedizione, (databaseError, databaseReference) -> {
            if (databaseError != null) {
                System.err.println("Errore durante l'inserimento della spedizione: " + databaseError.getMessage());
            }
        });
    }

    // Metodo per aggiornare una chat esistente
    public void updateChat(String spedizioneID, SistemaSpedizione sistemaSpedizione) {
        notificheRef.child(spedizioneID).setValue(sistemaSpedizione, (databaseError, databaseReference) -> {
            if (databaseError != null) {
                System.err.println("Errore durante l'aggiornamento della spedizione: " + databaseError.getMessage());
            }
        });
    }

    // Metodo per eliminare una chat tramite il suo ID
    public void deleteChat(String spedizioneID) {
        notificheRef.child(spedizioneID).removeValue((databaseError, databaseReference) -> {
            if (databaseError != null) {
                System.err.println("Errore durante l'eliminazione della spedizione: " + databaseError.getMessage());
            }
        });
    }

}
