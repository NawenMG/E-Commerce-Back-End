package com.my_app.my_app.dbRT.Collections.PerChat;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

 public class Conversazione {
   
    @Autowired
    Messaggio messaggio;

    private int conversazioneID; 
    private boolean mutaConversazione; 
    private boolean bloccoConversazione; 
    private String[] users; 
    private List<Messaggio> messaggi;

    public Conversazione(){   
    }

    public int getConversazioneID() {
        return conversazioneID;
    }

    public void setConversazioneID(int conversazioneID) {
        this.conversazioneID = conversazioneID;
    }

    public boolean isMutaConversazione() {
        return mutaConversazione;
    }

    public void setMutaConversazione(boolean mutaConversazione) {
        this.mutaConversazione = mutaConversazione;
    }

    public boolean isBloccoConversazione() {
        return bloccoConversazione;
    }

    public void setBloccoConversazione(boolean bloccoConversazione) {
        this.bloccoConversazione = bloccoConversazione;
    }

    public String[] getUsers() {
        return users;
    }

    public List<Messaggio> getMessaggi() {
        return messaggi;
    }

    public void addMessaggio(Messaggio messaggio) {
        this.messaggi.add(messaggio); 
    }
}