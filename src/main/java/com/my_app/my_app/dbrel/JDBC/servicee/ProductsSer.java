package com.my_app.my_app.dbrel.JDBC.servicee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import com.my_app.my_app.dbrel.JDBC.model.Products;
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryProducts;
import com.my_app.my_app.dbrel.JDBC.repository.interfacee.*;

@Service
public class ProductsSer {

    @Autowired
    private ProductsRepI productsRepI;

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public List<Products> queryService(ParmQueryProducts parmQuery) {
        return productsRepI.query(parmQuery);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
     public void saveAllService(int number) {
        productsRepI.saveAll(number);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void insertProductService(Products product) {
        productsRepI.insertProduct(product);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void updateProductService(Products product) {
        productsRepI.updateProduct(product);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void deleteProductService(int productId) {
        productsRepI.deleteProduct(productId);
    }
}
