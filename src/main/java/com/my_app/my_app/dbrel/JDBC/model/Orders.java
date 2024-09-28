package com.my_app.my_app.dbrel.JDBC.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;

public class Orders {
    @NotBlank(message = "Obbligatorio")
    private int orderID;                // Chiave primaria

    @NotBlank(message = "Obbligatorio")
    private int usersID;                // Riferimento all'ID dell'utente

    @NotBlank(message = "Obbligatorio")
    private LocalTime statoDiSpedizione; // Stato di spedizione

    @NotBlank(message = "Obbligatorio")
    private LocalDate dataDiConsegna;   // Data di consegna

    @NotBlank(message = "Obbligatorio")
    private LocalDate dataDiRichiesta;   // Data di richiesta

    @NotBlank(message = "Obbligatorio")
    private boolean accettazioneOrdine; // Accettazione ordine

    @NotBlank(message = "Obbligatorio")
    private boolean status;              // Stato dell'ordine

    @NotBlank(message = "Obbligatorio")
    private String corriere;             // Nome del corriere

    @NotBlank(message = "Obbligatorio")
    private String posizione;            // Posizione dell'ordine

    // Costruttore
    public Orders() {
        
    }

    // Getters e Setters
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getUsersID() {
        return usersID;
    }

    public void setUsersID(int usersID) {
        this.usersID = usersID;
    }

    public LocalTime getStatoDiSpedizione() {
        return statoDiSpedizione;
    }

    public void setStatoDiSpedizione(LocalTime statoDiSpedizione) {
        this.statoDiSpedizione = statoDiSpedizione;
    }

    public LocalDate getDataDiConsegna() {
        return dataDiConsegna;
    }

    public void setDataDiConsegna(LocalDate dataDiConsegna) {
        this.dataDiConsegna = dataDiConsegna;
    }

    public LocalDate getDataDiRichiesta() {
        return dataDiRichiesta;
    }

    public void setDataDiRichiesta(LocalDate dataDiRichiesta) {
        this.dataDiRichiesta = dataDiRichiesta;
    }

    public boolean isAccettazioneOrdine() {
        return accettazioneOrdine;
    }

    public void setAccettazioneOrdine(boolean accettazioneOrdine) {
        this.accettazioneOrdine = accettazioneOrdine;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCorriere() {
        return corriere;
    }

    public void setCorriere(String corriere) {
        this.corriere = corriere;
    }

    public String getPosizione() {
        return posizione;
    }

    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }
}
