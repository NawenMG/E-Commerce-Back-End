package com.my_app.my_app.dbDoc.Collections;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

@Document(collection = "recensioni")
public class Recensioni {
    @Id
    private int idReview;
    private String titolo; // Corretto in camelCase
    private int rate;
    private String body;
    // Nel recensione inserisci il nome dello user e del product
    private boolean verificadellAcquisto;
    private boolean like;
    private boolean dislike;
    private List<String> tags = new ArrayList<>(); // Campo per accettare un insieme di valori
    private Map<String, Object> campiAggiuntivi = new HashMap<>(); // Per il client che può inserire nuovi campi

    // Costruttore
    public Recensioni() {}

    // Getters e Setters
    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isVerificadellAcquisto() {
        return verificadellAcquisto;
    }

    public void setVerificadellAcquisto(boolean verificadellAcquisto) {
        this.verificadellAcquisto = verificadellAcquisto;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public boolean isDislike() {
        return dislike;
    }

    public void setDislike(boolean dislike) {
        this.dislike = dislike;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Map<String, Object> getCampiAggiuntivi() {
        return campiAggiuntivi;
    }

    public void setCampiAggiuntivi(Map<String, Object> campiAggiuntivi) {
        this.campiAggiuntivi = campiAggiuntivi;
    }
}
