package com.my_app.my_app.dbrel.JDBC.servicee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.my_app.my_app.dbrel.JDBC.model.Orders;
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryOrders;
import com.my_app.my_app.dbrel.JDBC.repository.interfacee.OrdersRepI;

@Service
public class OrdersSer {

    @Autowired
    private OrdersRepI ordersRepI;

    // Query
    public List<Orders> queryService(ParmQueryOrders parmQuery) {
        return ordersRepI.query(parmQuery);
    }

    // Servizio per il faker
     public void saveAllService(List<Orders> orders) {
        ordersRepI.saveAll(orders);
    }

    // Inserimento di un ordine
    public void insertOrderService(Orders order) {
        ordersRepI.insertOrder(order);
    }

    // Aggiornamento di un ordine
    public void updateOrderService(Orders order) {
        ordersRepI.updateOrder(order);
    }

    // Eliminazione di un ordine
    public void deleteOrderService(int orderId) {
        ordersRepI.deleteOrder(orderId);
    }
}
