package com.my_app.my_app.dbCol.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;
import org.threeten.bp.ZonedDateTime;

@Table("ArchiviazioneTransizioni")
public class ArchiviazioneTransizioni {
    @Id
    private int id;
    private int orderID;
    private double totalImport;
    private ZonedDateTime data;
    private String metodoDiPagamento;
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
