package com.my_app.my_app.dbRT.webSocket.Services;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.my_app.my_app.dbRT.webSocket.Collections.Conversazione;
import com.my_app.my_app.dbRT.webSocket.Collections.MessaggioX;
import com.my_app.my_app.dbRT.webSocket.Collections.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Service
public class ChatSer {

    private final FirebaseDatabase firebaseDatabase;

    public ChatSer(FirebaseDatabase firebaseDatabase) {
        this.firebaseDatabase = firebaseDatabase;
    }

    // Metodo per salvare una conversazione
    public void saveConversation(Conversazione conversazione) {
        DatabaseReference convRef = firebaseDatabase.getReference("conversazioni");
        convRef.child(conversazione.getConversazioneID()).setValueAsync(conversazione);
    }

    // Metodo per ottenere una conversazione in base al suo ID
    public Conversazione getConversation(String conversazioneID) {
        DatabaseReference convRef = firebaseDatabase.getReference("conversazioni").child(conversazioneID);
        final Conversazione[] conversazione = {new Conversazione()};
        CountDownLatch latch = new CountDownLatch(1); // per gestire la sincronizzazione

        convRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                conversazione[0] = dataSnapshot.getValue(Conversazione.class);
                latch.countDown(); // decrementa il contatore quando i dati sono disponibili
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Gestisci l'errore
                latch.countDown();
            }
        });

        try {
            latch.await(); // aspetta che i dati siano disponibili
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return conversazione[0];
    }

    // Metodo per aggiungere un messaggio a una conversazione
    public void addMessageToConversation(String conversazioneID, MessaggioX messaggio) {
        DatabaseReference messagesRef = firebaseDatabase.getReference("conversazioni").child(conversazioneID).child("messaggi");

        // Salva il messaggio
        messagesRef.push().setValueAsync(messaggio);

        // Aggiorna l'ultimo messaggio della conversazione
        DatabaseReference lastMessageRef = firebaseDatabase.getReference("conversazioni").child(conversazioneID).child("ultimoMessaggio");
        lastMessageRef.setValueAsync(messaggio);
    }

    // Metodo per recuperare i messaggi di una conversazione
    public List<MessaggioX> getMessages(String conversazioneID) {
        DatabaseReference messagesRef = firebaseDatabase.getReference("conversazioni").child(conversazioneID).child("messaggi");
        List<MessaggioX> messaggi = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(1); // per gestire la sincronizzazione

        messagesRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    MessaggioX messaggio = snapshot.getValue(MessaggioX.class);
                    messaggi.add(messaggio);
                }
                latch.countDown(); // decrementa il contatore quando i dati sono disponibili
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Gestisci l'errore
                latch.countDown();
            }
        });

        try {
            latch.await(); // aspetta che i dati siano disponibili
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return messaggi;
    }

    // Metodo per recuperare gli utenti coinvolti in una conversazione
    public List<User> getConversationUsers(String conversazioneID) {
        DatabaseReference usersRef = firebaseDatabase.getReference("conversazioni").child(conversazioneID).child("users");
        List<User> users = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(1); // per gestire la sincronizzazione

        usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String userId = snapshot.getValue(String.class); // Assumiamo che siano ID utente
                    User user = getUser(userId); // Recupera l'utente per ID
                    users.add(user);
                }
                latch.countDown(); // decrementa il contatore quando i dati sono disponibili
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Gestisci l'errore
                latch.countDown();
            }
        });

        try {
            latch.await(); // aspetta che i dati siano disponibili
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return users;
    }

    // Metodo per salvare un utente
    public void saveUser(User user) {
        DatabaseReference userRef = firebaseDatabase.getReference("users");
        userRef.child(user.getUserId()).setValueAsync(user);
    }

    // Metodo per ottenere un utente per ID
    public User getUser(String userId) {
        DatabaseReference userRef = firebaseDatabase.getReference("users").child(userId);
        final User[] user = {new User()};
        CountDownLatch latch = new CountDownLatch(1); // per gestire la sincronizzazione

        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                user[0] = dataSnapshot.getValue(User.class);
                latch.countDown(); // decrementa il contatore quando i dati sono disponibili
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Gestisci l'errore
                latch.countDown();
            }
        });

        try {
            latch.await(); // aspetta che i dati siano disponibili
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return user[0];
    }
}
