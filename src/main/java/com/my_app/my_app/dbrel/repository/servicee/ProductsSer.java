package com.my_app.my_app.dbrel.repository.servicee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.my_app.my_app.dbrel.model.Products;
import com.my_app.my_app.dbrel.parametri.ParmQuery;
import com.my_app.my_app.dbrel.repository.interfacee.*;
import com.my_app.my_app.dbrel.Factories.Products.ProductsFaker;

@Service
public class ProductsSer {

    @Autowired
    private ProductsRepI productsRepI;

    //Query
    public List<Products> queryService(ParmQuery parmQuery) {
        return productsRepI.query(parmQuery);
    }

    //Servizio per il faker
    public void saveAllService(int numberOfProducts) {
        List<Products> products = ProductsFaker.createProducts(numberOfProducts);
        productsRepI.saveAll(products);
    }

    //Insert
    public void insertProductService(Products product) {
        productsRepI.insertProduct(product);
    }

    //Update
    public void updateProductService(Products product) {
        productsRepI.updateProduct(product);
    }

    //Delete
    public void deleteProductService(int productId) {
        productsRepI.deleteProduct(productId);
    }
}
