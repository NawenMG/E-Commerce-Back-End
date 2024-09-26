package com.my_app.my_app.dbrel.JPA.Servicee;

import com.my_app.my_app.dbrel.JPA.Entity.Products;
import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;
import com.my_app.my_app.dbrel.JPA.Repository.Classss.ProductsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsSer {

    @Autowired
    private ProductsRep productsRep;

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public List<Products> query(ParamQueryJpa paramQuery) {
        return productsRep.query(paramQuery);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void insert(Products product) {
        productsRep.insert(product);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void update(Products product) {
        productsRep.update(product);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void delete(Integer id) {
        productsRep.delete(id);
    }
}
