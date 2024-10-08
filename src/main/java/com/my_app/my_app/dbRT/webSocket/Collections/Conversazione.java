package com.my_app.my_app.dbRT.webSocket.Collections;

import java.util.List;

public class Conversazione {
    private String conversazioneID;       // ID della conversazione
    private boolean mutaConversazione;    // Se la conversazione è muta
    private boolean bloccoConversazione;  // Se la conversazione è bloccata
    private List<String> users;           // Lista degli ID degli utenti partecipanti
    private List<MessaggioX> messaggi;     // Lista dei messaggi
    private MessaggioX ultimoMessaggio;    // Ultimo messaggio nella conversazione
    private String nomeGruppo;            // Nome del gruppo (se è una conversazione di gruppo)

    public Conversazione() {
    }

    public String getConversazioneID() {
        return conversazioneID;
    }

    public void setConversazioneID(String conversazioneID) {
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

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public List<MessaggioX> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(List<MessaggioX> messaggi) {
        this.messaggi = messaggi;
    }

    public MessaggioX getUltimoMessaggio() {
        return ultimoMessaggio;
    }

    public void setUltimoMessaggio(MessaggioX ultimoMessaggio) {
        this.ultimoMessaggio = ultimoMessaggio;
    }

    public String getNomeGruppo() {
        return nomeGruppo;
    }

    public void setNomeGruppo(String nomeGruppo) {
        this.nomeGruppo = nomeGruppo;
    }
}
