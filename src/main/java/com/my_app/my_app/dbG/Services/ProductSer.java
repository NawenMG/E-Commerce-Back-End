package com.my_app.my_app.dbG.Services;

import com.my_app.my_app.dbG.Parametri.ParamQuery;
import com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione.NodeProduct;
import com.my_app.my_app.dbG.Repository.Classsss.ProductRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSer {

    @Autowired
    private ProductRep productRep;

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public List<NodeProduct> findByDynamicQuery(ParamQuery paramQuery) {
        return productRep.findByDynamicQuery(paramQuery);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void insertNodeProduct(NodeProduct product) {
        productRep.insertNodeProduct(product);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void updateNodeProduct(NodeProduct product) {
        productRep.updateNodeProduct(product);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void deleteNodeProduct(String productId) {
        productRep.deleteNodeProduct(productId);
    }
}
