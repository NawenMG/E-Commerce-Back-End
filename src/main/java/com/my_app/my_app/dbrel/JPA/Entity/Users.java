package com.my_app.my_app.dbrel.JPA.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UsersID;

    private String Nome;
    private String Cognome;
    private String Ruolo;
    private String NomeUtente;
    private String Email;
    private String Password;
    private String Immagine;
    private int Category;

    // Costruttore di default
    public Users() {}

    // Costruttore con parametri
    public Users(String nome, String cognome, String ruolo, String nomeUtente, String email, String password, String immagine, int category) {
        Nome = nome;
        Cognome = cognome;
        Ruolo = ruolo;
        NomeUtente = nomeUtente;
        Email = email;
        Password = password;
        Immagine = immagine;
        Category = category;
    }

    // Getters e setters
    public int getUsersID() {
        return UsersID;
    }

    public void setUsersID(int usersID) {
        UsersID = usersID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public String getRuolo() {
        return Ruolo;
    }

    public void setRuolo(String ruolo) {
        Ruolo = ruolo;
    }

    public String getNomeUtente() {
        return NomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        NomeUtente = nomeUtente;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getImmagine() {
        return Immagine;
    }

    public void setImmagine(String immagine) {
        Immagine = immagine;
    }

    public int getCategory() {
        return Category;
    }

    public void setCategory(int category) {
        Category = category;
    }
}
