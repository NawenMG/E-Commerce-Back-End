package com.my_app.my_app.dbrel.JPA.Servicee;

import com.my_app.my_app.dbrel.JPA.Entity.Products;
import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;
import com.my_app.my_app.dbrel.JPA.Repository.Classss.ProductsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsSer {

    @Autowired
    private ProductsRep productsRep;

    // Query per ottenere i prodotti in base ai parametri
    public List<Products> query(ParamQueryJpa paramQuery) {
        return productsRep.query(paramQuery);
    }

    // Inserire un nuovo prodotto
    public void insert(Products product) {
        productsRep.insert(product);
    }

    // Aggiornare un prodotto esistente
    public void update(Products product) {
        productsRep.update(product);
    }

    // Eliminare un prodotto per ID
    public void delete(Integer id) {
        productsRep.delete(id);
    }
}
