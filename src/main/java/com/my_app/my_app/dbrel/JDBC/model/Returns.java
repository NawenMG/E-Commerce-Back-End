package com.my_app.my_app.dbrel.JDBC.model;

import java.time.LocalDate;

public class Returns {
    private int returnsID;         // chiave primaria
    private int usersID;           // chiave esterna per la tabella Users
    private boolean status;         // stato del reso
    private boolean accettazioneReso; // accettazione del reso
    private LocalDate dataRichiesta; // data di richiesta del reso

    // Costruttore
    public Returns() {
        
    }

    // Getters e Setters
    public int getReturnsID() {
        return returnsID;
    }

    public void setReturnsID(int returnsID) {
        this.returnsID = returnsID;
    }

    public int getUsersID() {
        return usersID;
    }

    public void setUsersID(int usersID) {
        this.usersID = usersID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isAccettazioneReso() {
        return accettazioneReso;
    }

    public void setAccettazioneReso(boolean accettazioneReso) {
        this.accettazioneReso = accettazioneReso;
    }

    public LocalDate getDataRichiesta() {
        return dataRichiesta;
    }

    public void setDataRichiesta(LocalDate dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }
}
