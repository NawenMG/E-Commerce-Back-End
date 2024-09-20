package com.my_app.my_app.dbrel.model;

import java.time.LocalDate;

public class Payments {
    private int paymentsID;  // chiave primaria
    private String type;     // tipo di pagamento
    private LocalDate data;  // data del pagamento
    private boolean status;   // stato del pagamento
    private double total;     // totale del pagamento

    // Costruttore
    public Payments(int paymentsID, String type, LocalDate data, boolean status, double total) {
        this.paymentsID = paymentsID;
        this.type = type;
        this.data = data;
        this.status = status;
        this.total = total;
    }

    // Getters e Setters
    public int getPaymentsID() {
        return paymentsID;
    }

    public void setPaymentsID(int paymentsID) {
        this.paymentsID = paymentsID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

