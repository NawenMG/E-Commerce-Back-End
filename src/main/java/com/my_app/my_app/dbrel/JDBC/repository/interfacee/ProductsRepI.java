package com.my_app.my_app.dbrel.JDBC.repository.interfacee;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.my_app.my_app.dbrel.JDBC.model.Products;
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryProducts;

@Repository
public interface ProductsRepI {

    List<Products> query(ParmQueryProducts parmQuery);
    void saveAll(List<Products> products);
    void insertProduct(Products products);
    void updateProduct(Products products);
    void deleteProduct( int productId);
}
