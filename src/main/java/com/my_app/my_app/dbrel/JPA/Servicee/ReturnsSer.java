package com.my_app.my_app.dbrel.JPA.Servicee;

import com.my_app.my_app.dbrel.JPA.Entity.Returns;
import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;
import com.my_app.my_app.dbrel.JPA.Repository.Classss.ReturnsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnsSer {

    @Autowired
    private ReturnsRep returnsRep;

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public List<Returns> query(ParamQueryJpa paramQuery) {
        return returnsRep.query(paramQuery);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void insert(Returns returns) {
        returnsRep.insert(returns);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void update(Returns returns) {
        returnsRep.update(returns);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void delete(Integer id) {
        returnsRep.delete(id);
    }
}
