package com.my_app.my_app.dbrel.JDBC.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public class Payments {
    @NotBlank(message = "Obbligatorio")
    private int paymentsID;  // chiave primaria

    @NotBlank(message = "Obbligatorio")
    private String type;     // tipo di pagamento

    @NotBlank(message = "Obbligatorio")
    private LocalDate data;  // data del pagamento

    @NotBlank(message = "Obbligatorio")
    private boolean status;   // stato del pagamento

    @NotBlank(message = "Obbligatorio")
    private double total;     // totale del pagamento

    // Costruttore
    public Payments() {
        
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

