package com.my_app.my_app.dbCol.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;
import org.threeten.bp.ZonedDateTime;

import jakarta.validation.constraints.NotBlank;

@Table("ArchiviazioneSegnalazioni")
public class ArchiviazioneSegnalazioni {
    @Id
    @NotBlank(message = "Obbligatorio")
    private int id;

    @NotBlank(message = "Obbligatorio")
    private String utente;

    @NotBlank(message = "Obbligatorio")
    private String riferimento;

    @NotBlank(message = "Obbligatorio")
    private ZonedDateTime data;

    @NotBlank(message = "Obbligatorio")
    private String title;

    @NotBlank(message = "Obbligatorio")
    private String body;

    @NotBlank(message = "Obbligatorio")
    private String immagini;

    @NotBlank(message = "Obbligatorio")
    private String audio;

    @NotBlank(message = "Obbligatorio")
    private String video;

    public ArchiviazioneSegnalazioni() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public String getRiferimento() {
        return riferimento;
    }

    public void setRiferimento(String riferimento) {
        this.riferimento = riferimento;
    }

    public ZonedDateTime getData() {
        return data;
    }

    public void setData(ZonedDateTime data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImmagini() {
        return immagini;
    }

    public void setImmagini(String immagini) {
        this.immagini = immagini;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
