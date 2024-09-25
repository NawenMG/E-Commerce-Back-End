package com.my_app.my_app.dbRT.Collections.PerChat;

import java.time.LocalDate;

class Messaggio {
    private String text; 
    private boolean visualizzazione; 
    private String audio; 
    private String immagine; 
    private String video; 
    private String mittente; 
    private String destinatario; 
    private LocalDate timeStamp; 

    public Messaggio() {
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