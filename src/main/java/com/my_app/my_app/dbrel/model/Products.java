package com.my_app.my_app.dbrel.model;

import java.time.LocalDate;

public class Products {
    private int productId;          
    private String nome;            
    private double prezzo;          
    private String descrizione;     
    private String immagine;       
    private int amountAvailable;     
    private String categoria;
    private LocalDate dataDiInserimento; 

    public Products(
        int productId,
        String nome,
        double prezzo,
        String descrizione,
        String immagine,
        int amountAvailable,
        String categoria,
        LocalDate dataDiInserimento
    ) {
        this.productId = productId;
        this.nome = nome;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        this.immagine = immagine;
        this.amountAvailable = amountAvailable;
        this.categoria = categoria;
        this.dataDiInserimento = dataDiInserimento;
    }

    // Getter e Setter
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