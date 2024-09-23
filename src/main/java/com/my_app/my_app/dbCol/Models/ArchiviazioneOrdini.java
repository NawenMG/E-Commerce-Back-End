package com.my_app.my_app.dbCol.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;
import org.threeten.bp.ZonedDateTime;

import java.util.List;

@Table("ArchiviazioneOrdini")
public class ArchiviazioneOrdini {
    @Id
    private int id;
    private int userID;
    private ZonedDateTime orderDate;
    private String status;
    private double totalImport;
    private String indirizzo;
    private List<String> articoliOrdine;
    private ZonedDateTime dataConsegna;
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
