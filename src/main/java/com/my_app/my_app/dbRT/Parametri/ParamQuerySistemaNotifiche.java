package com.my_app.my_app.dbRT.Parametri;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DatabaseError;
import org.springframework.stereotype.Component;
import com.my_app.my_app.dbRT.Collections.SistemaNotifiche;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ParamQuerySistemaNotifiche {

    private DatabaseReference chatRef = FirebaseDatabase.getInstance().getReference("SistemaDiNotiche");

    // Variabili di istanza per le condizioni
    private Optional<String> condizioneWhere = Optional.empty(); 
    private Optional<String> valoriWhere = Optional.empty(); 
    private Optional<Integer> rate = Optional.empty(); 
    private Optional<Boolean> verificadellAcquisto = Optional.empty(); 
    private int limit = 40; 

    public void executeQuery(NotificheCallback callback) {
        Query query = chatRef;

        if (condizioneWhere.isPresent() && valoriWhere.isPresent()) {
            query = query.orderByChild(condizioneWhere.get()).equalTo(valoriWhere.get());
        }

        if (rate.isPresent()) {
            query = query.orderByChild("rate").equalTo(rate.get());
        }
        if (verificadellAcquisto.isPresent()) {
            query = query.orderByChild("verificadellAcquisto").equalTo(verificadellAcquisto.get());
        }

        query = query.limitToFirst(limit);

        // Listener asincrono per recuperare i dati
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<SistemaNotifiche> noticheList = new ArrayList<>();
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    SistemaNotifiche notifiche = data.getValue(SistemaNotifiche.class);
                    noticheList.add(notifiche);
                }
                // Chiama il callback per restituire i risultati
                callback.onSuccess(noticheList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                callback.onError(databaseError.toException());
            }
        });
    }

    // Interfaccia per callback asincrono
    public interface NotificheCallback {
        void onSuccess(List<SistemaNotifiche> notificheList);
        void onError(Exception e);
    }
}
