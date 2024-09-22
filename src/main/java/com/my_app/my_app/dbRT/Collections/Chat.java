package com.my_app.my_app.dbRT.Collections;

import org.threeten.bp.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Chat {
    private List<Conversazione> conversazioni; // Lista delle conversazioni

    public Chat() {
        this.conversazioni = new ArrayList<>(); 
    }


    public List<Conversazione> getConversazioni() {
        return conversazioni;
    }

    public void addConversazione(Conversazione conversazione) {
        this.conversazioni.add(conversazione); 
    }
}

class Conversazione {
    private int conversazioneID; 
    private boolean mutaConversazione; 
    private boolean bloccoConversazione; 
    private String[] users; 
    private List<Messaggio> messaggi;

    public Conversazione(int conversazioneID, boolean mutaConversazione, boolean bloccoConversazione, String user1, String user2) {
        this.conversazioneID = conversazioneID;
        this.mutaConversazione = mutaConversazione;
        this.bloccoConversazione = bloccoConversazione;
        this.users = new String[]{user1, user2}; 
        this.messaggi = new ArrayList<>(); 
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

class Messaggio {
    private String text; 
    private boolean visualizzazione; 
    private String audio; 
    private String immagine; 
    private String video; 
    private String mittente; 
    private String destinatario; 
    private LocalDate timeStamp; 

    public Messaggio(String text, boolean visualizzazione, String audio, String immagine, String video, String mittente, String destinatario) {
        this.text = text;
        this.visualizzazione = visualizzazione;
        this.audio = audio;
        this.immagine = immagine;
        this.video = video;
        this.mittente = mittente;
        this.destinatario = destinatario;
        this.timeStamp = LocalDate.now(); 
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isVisualizzazione() {
        return visualizzazione;
    }

    public void setVisualizzazione(boolean visualizzazione) {
        this.visualizzazione = visualizzazione;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getMittente() {
        return mittente;
    }

    public void setMittente(String mittente) {
        this.mittente = mittente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }
}
