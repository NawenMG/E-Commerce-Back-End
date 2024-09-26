package com.my_app.my_app.dbrel.JDBC.servicee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import com.my_app.my_app.dbrel.JDBC.model.Orders;
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryOrders;
import com.my_app.my_app.dbrel.JDBC.repository.interfacee.OrdersRepI;

@Service
public class OrdersSer {

    @Autowired
    private OrdersRepI ordersRepI;

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public List<Orders> queryService(ParmQueryOrders parmQuery) {
        return ordersRepI.query(parmQuery);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
     public void saveAllService(int number) {
        ordersRepI.saveAll(number);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void insertOrderService(Orders order) {
        ordersRepI.insertOrder(order);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void updateOrderService(Orders order) {
        ordersRepI.updateOrder(order);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void deleteOrderService(int orderId) {
        ordersRepI.deleteOrder(orderId);
    }
}
