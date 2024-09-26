package com.my_app.my_app.dbrel.JPA.Servicee;

import com.my_app.my_app.dbrel.JPA.Entity.Orders;
import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;
import com.my_app.my_app.dbrel.JPA.Repository.Classss.OrdersRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersSer {

    @Autowired
    private OrdersRep ordersRep;

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public List<Orders> query(ParamQueryJpa paramQuery) {
        return ordersRep.query(paramQuery);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void insert(Orders order) {
        ordersRep.insert(order);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void update(Orders order) {
        ordersRep.update(order);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void delete(Integer id) {
        ordersRep.delete(id);
    }
}
