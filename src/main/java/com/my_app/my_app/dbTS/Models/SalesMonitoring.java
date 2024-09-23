package com.my_app.my_app.dbTS.Models;

import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;
import org.threeten.bp.ZonedDateTime;

@Measurement(name = "SalesMonitoring")
public class SalesMonitoring {
    // Tag
    @Column(name = "Product")
    private String product; 

    @Column(name = "Category")
    private String category; 

    @Column(name = "Venditore")
    private String venditore; 

    // Field
    @Column(name = "NumeroOrdini")
    private int numeroOrdini; 

    @Column(name = "NumeroUnitàVendute")
    private int numeroUnitàVendute; 

    @Column(name = "Ricavo")
    private double ricavo; 

    // Timestamp
    @Column(name = "TimeStamp")
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
