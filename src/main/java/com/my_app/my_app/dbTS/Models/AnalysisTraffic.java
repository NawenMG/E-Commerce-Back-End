package com.my_app.my_app.dbTS.Models;

import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;
import org.threeten.bp.ZonedDateTime;

import jakarta.validation.constraints.NotBlank;

@Measurement(name = "AnalysisTraffic")
public class AnalysisTraffic {
    // Tag
    @NotBlank(message = "Obbligatorio")
    @Column(name = "Url")
    private String url;

    // Field
    @Column(name = "NumeroVisite")
    @NotBlank(message = "Obbligatorio")
    private int numeroVisite;

    @Column(name = "NumeroVisiteUniche")
    @NotBlank(message = "Obbligatorio")
    private int numeroVisiteUniche;

    @Column(name = "DurataMediaVisite")
    @NotBlank(message = "Obbligatorio")
    private double durataMediaVisite; 

    // Timestamp
    @Column(name = "TimeStamp")
    @NotBlank(message = "Obbligatorio")
    private ZonedDateTime timeStamp; 
    
    public AnalysisTraffic() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumeroVisite() {
        return numeroVisite;
    }

    public void setNumeroVisite(int numeroVisite) {
        this.numeroVisite = numeroVisite;
    }

    public int getNumeroVisiteUniche() {
        return numeroVisiteUniche;
    }

    public void setNumeroVisiteUniche(int numeroVisiteUniche) {
        this.numeroVisiteUniche = numeroVisiteUniche;
    }

    public double getDurataMediaVisite() {
        return durataMediaVisite;
    }

    public void setDurataMediaVisite(double durataMediaVisite) {
        this.durataMediaVisite = durataMediaVisite;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(ZonedDateTime timeStamp) {
        if (timeStamp == null) {
            throw new IllegalArgumentException("Timestamp cannot be null");
        }
        this.timeStamp = timeStamp;
    }
}
