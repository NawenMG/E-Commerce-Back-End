package com.my_app.my_app.dbrel.JPA.Servicee;

import com.my_app.my_app.dbrel.JPA.Entity.Orders;
import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;
import com.my_app.my_app.dbrel.JPA.Repository.Classss.OrdersRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersSer {

    @Autowired
    private OrdersRep ordersRep;

    // Query per ottenere gli ordini in base ai parametri
    public List<Orders> query(ParamQueryJpa paramQuery) {
        return ordersRep.query(paramQuery);
    }

    // Inserire un nuovo ordine
    public void insert(Orders order) {
        ordersRep.insert(order);
    }

    // Aggiornare un ordine esistente
    public void update(Orders order) {
        ordersRep.update(order);
    }

    // Eliminare un ordine per ID
    public void delete(Integer id) {
        ordersRep.delete(id);
    }
}
