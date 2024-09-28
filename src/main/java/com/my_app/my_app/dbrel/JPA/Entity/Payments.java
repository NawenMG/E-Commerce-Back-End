package com.my_app.my_app.dbrel.JPA.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

@Entity
@Table(name = "Payments")
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "Obbligatorio")
    private int PaymentsID;

    @NotBlank(message = "Obbligatorio")
    private String Type;

    @NotBlank(message = "Obbligatorio")
    private Date Data;

    @NotBlank(message = "Obbligatorio")
    private boolean Status;

    @NotBlank(message = "Obbligatorio")
    private double Total;

    // Costruttore di default
    public Payments() {}

    // Costruttore con parametri
    public Payments(String type, Date data, boolean status, double total) {
        Type = type;
        Data = data;
        Status = status;
        Total = total;
    }

    // Getters e setters
    public int getPaymentsID() {
        return PaymentsID;
    }

    public void setPaymentsID(int paymentsID) {
        PaymentsID = paymentsID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date data) {
        Data = data;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }
}
