package com.my_app.my_app.dbRT.webSocket.Collections;

import org.threeten.bp.LocalDate;

public class MessaggioX {
    private String messaggioID;      // ID del messaggio
    private String text;             // Contenuto del messaggio
    private boolean visualizzato;    // Stato di visualizzazione del messaggio
    private String mittente;         // ID del mittente
    private String destinatario;     // ID del destinatario
    private String tipo;             // Tipo di messaggio: testo, immagine, video, audio, ecc.
    private LocalDate timeStamp;     // Data e ora del messaggio
    private String urlAllegato;      // URL dell'allegato (immagine, video, audio, ecc.)

    public MessaggioX() {
    }

    public String getMessaggioID() {
        return messaggioID;
    }

    public void setMessaggioID(String messaggioID) {
        this.messaggioID = messaggioID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isVisualizzato() {
        return visualizzato;
    }

    public void setVisualizzato(boolean visualizzato) {
        this.visualizzato = visualizzato;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUrlAllegato() {
        return urlAllegato;
    }

    public void setUrlAllegato(String urlAllegato) {
        this.urlAllegato = urlAllegato;
    }
}
