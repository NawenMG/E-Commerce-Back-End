package com.my_app.my_app.dbrel.JPA.Repository.Interfaceeee;

import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;
import com.my_app.my_app.dbrel.JPA.Entity.Products;

import java.util.List;

public interface ProductsRepI {
    List<Products> query(ParamQueryJpa paramQueryJpa);
    void insert(Products products);
    void update(Products products);
    void delete(Integer id);
    
}