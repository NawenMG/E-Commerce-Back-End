package com.my_app.my_app.dbTS.Models;

import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;
import org.threeten.bp.ZonedDateTime;

import jakarta.validation.constraints.NotBlank;

@Measurement(name = "SalesMonitoring")
public class SalesMonitoring {
    // Tag
    @Column(name = "Product")
    @NotBlank(message = "Obbligatorio")
    private String product; 

    @Column(name = "Category")
    @NotBlank(message = "Obbligatorio")
    private String category; 

    @Column(name = "Venditore")
    @NotBlank(message = "Obbligatorio")
    private String venditore; 

    // Field
    @Column(name = "NumeroOrdini")
    @NotBlank(message = "Obbligatorio")
    private int numeroOrdini; 

    @Column(name = "NumeroUnitàVendute")
    @NotBlank(message = "Obbligatorio")
    private int numeroUnitàVendute; 

    @Column(name = "Ricavo")
    @NotBlank(message = "Obbligatorio")
    private double ricavo; 

    // Timestamp
    @Column(name = "TimeStamp")
    @NotBlank(message = "Obbligatorio")
    private ZonedDateTime timeStamp; 

    public SalesMonitoring() {
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVenditore() {
        return venditore;
    }

    public void setVenditore(String venditore) {
        this.venditore = venditore;
    }

    public int getNumeroOrdini() {
        return numeroOrdini;
    }

    public void setNumeroOrdini(int numeroOrdini) {
        this.numeroOrdini = numeroOrdini;
    }

    public int getNumeroUnitàVendute() {
        return numeroUnitàVendute;
    }

    public void setNumeroUnitàVendute(int numeroUnitàVendute) {
        this.numeroUnitàVendute = numeroUnitàVendute;
    }

    public double getRicavo() {
        return ricavo;
    }

    public void setRicavo(double ricavo) {
        this.ricavo = ricavo;
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
