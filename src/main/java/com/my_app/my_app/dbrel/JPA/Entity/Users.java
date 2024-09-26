package com.my_app.my_app.dbrel.JPA.Entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

import com.my_app.my_app.security.sessioniwithJWT.UsersRole.Role;





@Entity
@Table(name = "Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UsersID;

    private String Nome;
    private String Cognome;

    @ElementCollection(targetClass = Role.class)
    @Enumerated(EnumType.STRING)
    private Set<Role> Ruolo = new HashSet<>(); // Usare un Set per gestire i ruoli

    private String NomeUtente;
    private String Email;
    private String Password;
    private String Immagine;
    private int Category;

    // Costruttore di default
    public Users() {}

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

    public Set<Role> getRuolo() {
        return Ruolo;
    }

    public void setRuolo(Set<Role> ruolo) {
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
