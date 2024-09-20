package com.my_app.my_app.dbrel.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Orders {
    private int orderID;                // Chiave primaria
    private int usersID;                // Riferimento all'ID dell'utente
    private LocalTime statoDiSpedizione; // Stato di spedizione
    private LocalDate dataDiConsegna;   // Data di consegna
    private LocalDate dataDiRichiesta;   // Data di richiesta
    private boolean accettazioneOrdine; // Accettazione ordine
    private boolean status;              // Stato dell'ordine
    private String corriere;             // Nome del corriere
    private String posizione;            // Posizione dell'ordine

    // Costruttore
    public Orders(int orderID, int usersID, LocalTime statoDiSpedizione, LocalDate dataDiConsegna, 
                  LocalDate dataDiRichiesta, boolean accettazioneOrdine, boolean status, 
                  String corriere, String posizione) {
        this.orderID = orderID;
        this.usersID = usersID;
        this.statoDiSpedizione = statoDiSpedizione;
        this.dataDiConsegna = dataDiConsegna;
        this.dataDiRichiesta = dataDiRichiesta;
        this.accettazioneOrdine = accettazioneOrdine;
        this.status = status;
        this.corriere = corriere;
        this.posizione = posizione;
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
