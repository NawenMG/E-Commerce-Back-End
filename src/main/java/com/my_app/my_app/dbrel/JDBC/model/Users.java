package com.my_app.my_app.dbrel.JDBC.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Users {
    @NotBlank(message = "Obbligatorio")
    private int usersID;          // UsersID

    @NotBlank(message = "Obbligatorio")
    private String nome;          // Nome

    @NotBlank(message = "Obbligatorio")
    private String cognome;       // Cognome

    @NotBlank(message = "Obbligatorio")
    private String ruolo;         // Ruolo

    @NotBlank(message = "Obbligatorio")
    private String nomeUtente;    // NomeUtente

    @NotBlank(message = "Obbligatorio")
    @Email(message = "L'email non è valida")
    private String email;         // Email

    @NotBlank(message = "Obbligatorio")
    @Size(min = 10, max = 20, message = "Il nome deve avere tra i 10 e i 20 caratteri")
    private String password;      // Password

    private String immagine;      // Immagine

    @NotBlank(message = "Obbligatorio")
    private int category;         // Category

    public Users(
        
    ) {
        
    }

    // Getter e Setter
    public int getUsersID() {
        return usersID;
    }

    public void setUsersID(int usersID) {
        this.usersID = usersID;
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

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}

    

