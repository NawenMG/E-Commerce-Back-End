package com.my_app.my_app.dbrel.JPA.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

import com.my_app.my_app.security.sessioniWithJWT.UsersRole.*;





@Entity
@Table(name = "Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "Obbligatorio")
    private int UsersID;

    @NotBlank(message = "Obbligatorio")
    private String Nome;

    @NotBlank(message = "Obbligatorio")
    private String Cognome;

    @ElementCollection(targetClass = Role.class)
    @Enumerated(EnumType.STRING)
    @NotEmpty(message = "La lista non può essere vuota")
    private Set<Role> Ruolo = new HashSet<>(); // Usare un Set per gestire i ruoli

    @NotBlank(message = "Obbligatorio")
    private String NomeUtente;

    @NotBlank(message = "Obbligatorio")
    @jakarta.validation.constraints.Email(message = "L'email non è valida")
    private String Email;

    @Size(min = 10, max = 20, message = "Il nome deve avere tra 10 e 20 caratteri")
    @NotBlank(message = "Obbligatorio")
    private String Password;

    private String Immagine;

    @NotBlank(message = "Obbligatorio")
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
