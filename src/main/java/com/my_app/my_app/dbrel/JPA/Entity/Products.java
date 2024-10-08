package com.my_app.my_app.dbrel.JPA.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
@Table(name = "Products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "Obbligatorio")
    private int productId;

    @NotBlank(message = "Obbligatorio")
    private String nome;

    @NotBlank(message = "Obbligatorio")
    private double prezzo;

    @NotBlank(message = "Obbligatorio")
    private String descrizione;

    @NotBlank(message = "Obbligatorio")
    private String immagine;

    @NotBlank(message = "Obbligatorio")
    private int amountAvailable;

    @NotBlank(message = "Obbligatorio")
    private String categoria;

    @NotBlank(message = "Obbligatorio")
    private LocalDate dataDiInserimento;

    // Costruttore di default
    public Products() {}

    // Costruttore con parametri
    public Products(String nome, double prezzo, String descrizione, String immagine, int amountAvailable, String categoria, LocalDate dataDiInserimento) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        this.immagine = immagine;
        this.amountAvailable = amountAvailable;
        this.categoria = categoria;
        this.dataDiInserimento = dataDiInserimento;
    }

    // Getters e setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public int getAmountAvailable() {
        return amountAvailable;
    }

    public void setAmountAvailable(int amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getDataDiInserimento() {
        return dataDiInserimento;
    }

    public void setDataDiInserimento(LocalDate dataDiInserimento) {
        this.dataDiInserimento = dataDiInserimento;
    }
}
