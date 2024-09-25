package com.my_app.my_app.dbRT.Collections;

import java.util.List;

public class SistemaNotifiche {
    private List<Notifica> notifiche;  

    // Costruttore
    public SistemaNotifiche() {
    }

    // Getters e Setters
    public List<Notifica> getNotifiche() {
        return notifiche;
    }

    public void addNotifica(Notifica notifica) {
        this.notifiche.add(notifica);  
    }
}

class Notifica {
    private int notificaID;           
    private String text;              
    private String audio;            
    private String immagine;          
    private String video;             
    private boolean consegna;         
    private boolean visualizzazione;  
    private String destinatario;      

    // Costruttore
    public Notifica() {
       
    }

    public int getNotificaID() {
        return notificaID;
    }

    public void setNotificaID(int notificaID) {
        this.notificaID = notificaID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public boolean isConsegna() {
        return consegna;
    }

    public void setConsegna(boolean consegna) {
        this.consegna = consegna;
    }

    public boolean isVisualizzazione() {
        return visualizzazione;
    }

    public void setVisualizzazione(boolean visualizzazione) {
        this.visualizzazione = visualizzazione;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
}
