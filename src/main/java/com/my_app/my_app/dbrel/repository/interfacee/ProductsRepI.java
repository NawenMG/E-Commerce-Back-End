package com.my_app.my_app.dbrel.repository.interfacee;

import java.util.List;
import com.my_app.my_app.dbrel.model.Products;
import com.my_app.my_app.dbrel.parametri.ParmQuery;


public interface ProductsRepI {

    List<Products> query(ParmQuery parmQuery);
    void saveAll(List<Products> products);
    void insertProduct(Products products);
    void updateProduct(Products products);
    void deleteProduct( int productId);



}
