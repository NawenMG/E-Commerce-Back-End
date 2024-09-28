package com.my_app.my_app.dbrel.JPA.Entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Returns")
public class Returns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "Obbligatorio")
    private int ReturnsID;

    @ManyToOne
    @JoinColumn(name = "UsersID", nullable = false)
    @NotBlank(message = "Obbligatorio")
    private Users user;

    @NotBlank(message = "Obbligatorio")
    private boolean Status;

    @NotBlank(message = "Obbligatorio")
    private boolean AccettazioneReso;

    @NotBlank(message = "Obbligatorio")
    private LocalDate DataRichiesta;

    // Costruttore di default
    public Returns() {}

    // Costruttore con parametri
    public Returns(Users user, boolean status, boolean accettazioneReso, LocalDate dataRichiesta) {
        this.user = user;
        Status = status;
        AccettazioneReso = accettazioneReso;
        DataRichiesta = dataRichiesta;
    }

    // Getters e setters
    public int getReturnsID() {
        return ReturnsID;
    }

    public void setReturnsID(int returnsID) {
        ReturnsID = returnsID;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public boolean isAccettazioneReso() {
        return AccettazioneReso;
    }

    public void setAccettazioneReso(boolean accettazioneReso) {
        AccettazioneReso = accettazioneReso;
    }

    public LocalDate getDataRichiesta() {
        return DataRichiesta;
    }

    public void setDataRichiesta(LocalDate dataRichiesta) {
        DataRichiesta = dataRichiesta;
    }
}
