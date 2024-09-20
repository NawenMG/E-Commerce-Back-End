package com.my_app.my_app.dbrel.servicee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.my_app.my_app.dbrel.Factories.Random.OrdersFaker;
import com.my_app.my_app.dbrel.model.Orders;
import com.my_app.my_app.dbrel.parametri.ParmQueryOrders;
import com.my_app.my_app.dbrel.repository.interfacee.OrdersRepI;

@Service
public class OrdersSer {

    @Autowired
    private OrdersRepI ordersRepI;

    // Query
    public List<Orders> queryService(ParmQueryOrders parmQuery) {
        return ordersRepI.query(parmQuery);
    }

    // Servizio per il faker
    public void saveAllService(int numberOfOrders) {
        List<Orders> orders = OrdersFaker.createOrders(numberOfOrders);
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
