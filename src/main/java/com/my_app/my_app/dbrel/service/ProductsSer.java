package com.my_app.my_app.dbrel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.my_app.my_app.dbrel.repository.ProductsRep;
import com.my_app.my_app.dbrel.model.Products;
import com.my_app.my_app.dbrel.parametri.ParmQuery;
import com.my_app.my_app.dbrel.parametri.ParmQueryService;

@Service
public class ProductsSer {

    @Autowired
    private final ProductsRep productsRep;

    //Query
    public List<Products> query(ParmQueryService parmQueryService) {
        return productsRep.query(parmQueryService);
    }

    //Servizio per il faker
    public void generateAndSaveProducts(int numberOfProducts) {
        List<Products> products = ProductsFaker.createProducts(numberOfProducts);
        productsRep.saveAll(products);
    }

    //Insert
    public void createProduct(Products product) {
        productRep.insertProduct(product);
    }

    //Update
    public void updateProduct(Products product) {
        productRep.updateProduct(product);
    }

    //Delete
    public void deleteProduct(int productId) {
        productRep.deleteProduct(productId);
    }
}
