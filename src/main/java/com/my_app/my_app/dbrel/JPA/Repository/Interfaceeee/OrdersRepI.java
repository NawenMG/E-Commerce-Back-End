package com.my_app.my_app.dbrel.JPA.Repository.Interfaceeee;

import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;
import com.my_app.my_app.dbrel.JPA.Entity.Orders;

import java.util.List;

public interface OrdersRepI {
    List<Orders> query(ParamQueryJpa paramQueryJpa);
    void insert(Orders orders);
    void update(Orders orders);
    void delete(Integer id);
    
}