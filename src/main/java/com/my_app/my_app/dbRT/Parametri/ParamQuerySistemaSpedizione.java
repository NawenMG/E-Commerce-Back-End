package com.my_app.my_app.dbRT.Parametri;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DatabaseError;
import org.springframework.stereotype.Component;
import com.my_app.my_app.dbRT.Collections.SistemaSpedizione;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ParamQuerySistemaSpedizione {

    private DatabaseReference chatRef = FirebaseDatabase.getInstance().getReference("chat");

    private Optional<String> condizioneWhere = Optional.empty(); 
    private Optional<String> valoriWhere = Optional.empty(); 
    private Optional<Integer> rate = Optional.empty(); 
    private Optional<Boolean> verificadellAcquisto = Optional.empty(); 
    private int limit = 40; 

    public void executeQuery(SpedizioneCallback callback) {
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
                List<SistemaSpedizione> spedizioniList = new ArrayList<>();
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    SistemaSpedizione spedizione = data.getValue(SistemaSpedizione.class);
                    spedizioniList.add(spedizione);
                }
                // Chiama il callback per restituire i risultati
                callback.onSuccess(spedizioniList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                callback.onError(databaseError.toException());
            }
        });
    }

    // Interfaccia per callback asincrono
    public interface SpedizioneCallback {
        void onSuccess(List<SistemaSpedizione> spedizioniList);
        void onError(Exception e);
    }
}
