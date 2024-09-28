package com.my_app.my_app.dbCol.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;
import org.threeten.bp.ZonedDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Table("ArchiviazioneOrdini")
public class ArchiviazioneOrdini {
    @Id
    @NotBlank(message = "Obbligatorio")
    private int id;

    @NotBlank(message = "Obbligatorio")
    private int userID;

    @NotBlank(message = "Obbligatorio")
    private ZonedDateTime orderDate;

    @NotBlank(message = "Obbligatorio")
    private String status;

    @NotBlank(message = "Obbligatorio")
    private double totalImport;
    
    @NotBlank(message = "Obbligatorio")
    private String indirizzo;

    @NotEmpty(message = "La lista non può essere vuota")
    private List<String> articoliOrdine;

    @NotBlank(message = "Obbligatorio")
    private ZonedDateTime dataConsegna;

    @NotBlank(message = "Obbligatorio")
    private String corriere;

    public ArchiviazioneOrdini() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public ZonedDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(ZonedDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalImport() {
        return totalImport;
    }

    public void setTotalImport(double totalImport) {
        this.totalImport = totalImport;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public List<String> getArticoliOrdine() {
        return articoliOrdine;
    }

    public void setArticoliOrdine(List<String> articoliOrdine) {
        this.articoliOrdine = articoliOrdine;
    }

    public ZonedDateTime getDataConsegna() {
        return dataConsegna;
    }

    public void setDataConsegna(ZonedDateTime dataConsegna) {
        this.dataConsegna = dataConsegna;
    }

    public String getCorriere() {
        return corriere;
    }

    public void setCorriere(String corriere) {
        this.corriere = corriere;
    }
}
