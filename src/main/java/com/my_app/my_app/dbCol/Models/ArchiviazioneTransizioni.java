package com.my_app.my_app.dbCol.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;
import org.threeten.bp.ZonedDateTime;

import jakarta.validation.constraints.NotBlank;

@Table("ArchiviazioneTransizioni")
public class ArchiviazioneTransizioni {
    @Id
    @NotBlank(message = "Obbligatorio")
    private int id;

    @NotBlank(message = "Obbligatorio")
    private int orderID;

    @NotBlank(message = "Obbligatorio")
    private double totalImport;

    @NotBlank(message = "Obbligatorio")
    private ZonedDateTime data;

    @NotBlank(message = "Obbligatorio")
    private String metodoDiPagamento;

    @NotBlank(message = "Obbligatorio")
    private String status;

    public ArchiviazioneTransizioni() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public double getTotalImport() {
        return totalImport;
    }

    public void setTotalImport(double totalImport) {
        this.totalImport = totalImport;
    }

    public ZonedDateTime getData() {
        return data;
    }

    public void setData(ZonedDateTime data) {
        this.data = data;
    }

    public String getMetodoDiPagamento() {
        return metodoDiPagamento;
    }

    public void setMetodoDiPagamento(String metodoDiPagamento) {
        this.metodoDiPagamento = metodoDiPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
