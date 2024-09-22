package com.my_app.my_app.dbRT.Collections;

import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.LocalDate;

public class SistemaSpedizione {
    private List<Spedizione> spedizioni;  

    public SistemaSpedizione() {
        this.spedizioni = new ArrayList<>();  
    }

    public List<Spedizione> getSpedizioni() {
        return spedizioni;
    }

    public void addSpedizione(Spedizione spedizione) {
        this.spedizioni.add(spedizione);  
    }
}

class Spedizione {
    private int spedizioneID;                      
    private String aziendaInCaricoPerLaSpedizione;  
    private boolean consegna;                      
    private LocalDate dataDiConsegnaPrevista;      
    private LocalDate ritardo;                     
    private String locazioneCorrente;              
    private List<String> storicoLocazioni;         
    private LocalDate timeStamp;                   
    private List<User> utenti;                    

    public Spedizione(int spedizioneID, String aziendaInCaricoPerLaSpedizione, boolean consegna, 
                      LocalDate dataDiConsegnaPrevista, LocalDate ritardo, String locazioneCorrente, 
                      List<String> storicoLocazioni, LocalDate timeStamp, List<User> utenti) {
        this.spedizioneID = spedizioneID;
        this.aziendaInCaricoPerLaSpedizione = aziendaInCaricoPerLaSpedizione;
        this.consegna = consegna;
        this.dataDiConsegnaPrevista = dataDiConsegnaPrevista;
        this.ritardo = ritardo;
        this.locazioneCorrente = locazioneCorrente;
        this.storicoLocazioni = storicoLocazioni;
        this.timeStamp = timeStamp;
        this.utenti = utenti;
    }

    public int getSpedizioneID() {
        return spedizioneID;
    }

    public void setSpedizioneID(int spedizioneID) {
        this.spedizioneID = spedizioneID;
    }

    public String getAziendaInCaricoPerLaSpedizione() {
        return aziendaInCaricoPerLaSpedizione;
    }

    public void setAziendaInCaricoPerLaSpedizione(String aziendaInCaricoPerLaSpedizione) {
        this.aziendaInCaricoPerLaSpedizione = aziendaInCaricoPerLaSpedizione;
    }

    public boolean isConsegna() {
        return consegna;
    }

    public void setConsegna(boolean consegna) {
        this.consegna = consegna;
    }

    public LocalDate getDataDiConsegnaPrevista() {
        return dataDiConsegnaPrevista;
    }

    public void setDataDiConsegnaPrevista(LocalDate dataDiConsegnaPrevista) {
        this.dataDiConsegnaPrevista = dataDiConsegnaPrevista;
    }

    public LocalDate getRitardo() {
        return ritardo;
    }

    public void setRitardo(LocalDate ritardo) {
        this.ritardo = ritardo;
    }

    public String getLocazioneCorrente() {
        return locazioneCorrente;
    }

    public void setLocazioneCorrente(String locazioneCorrente) {
        this.locazioneCorrente = locazioneCorrente;
    }

    public List<String> getStoricoLocazioni() {
        return storicoLocazioni;
    }

    public void setStoricoLocazioni(List<String> storicoLocazioni) {
        this.storicoLocazioni = storicoLocazioni;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<User> getUtenti() {
        return utenti;
    }

    public void setUtenti(List<User> utenti) {
        this.utenti = utenti;
    }
}

class User {
    private int userID;              
    private String nome;            
    private String cognome;         
    private String email;            
    private String indirizzo;        
    private String phoneNumber;      

    // Costruttore
    public User(int userID, String nome, String cognome, String email, 
                String indirizzo, String phoneNumber) {
        this.userID = userID;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.indirizzo = indirizzo;
        this.phoneNumber = phoneNumber;
    }

    // Getters e Setters
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}