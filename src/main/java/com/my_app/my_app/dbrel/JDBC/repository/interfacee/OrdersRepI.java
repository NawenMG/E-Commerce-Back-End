package com.my_app.my_app.dbrel.JDBC.repository.interfacee;

import com.my_app.my_app.dbrel.JDBC.model.Orders;
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryOrders;

import java.util.List;

public interface OrdersRepI {
    List<Orders> query(ParmQueryOrders parmQuery);
    void saveAll(int number);
    void insertOrder(Orders order);
    void updateOrder(Orders order);
    void deleteOrder(int orderId);
}
