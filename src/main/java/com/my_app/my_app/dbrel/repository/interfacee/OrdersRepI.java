package com.my_app.my_app.dbrel.repository.interfacee;

import com.my_app.my_app.dbrel.model.Orders;
import com.my_app.my_app.dbrel.parametri.ParmQueryOrders;

import java.util.List;

public interface OrdersRepI {
    List<Orders> query(ParmQueryOrders parmQuery);
    void saveAll(List<Orders> orders);
    void insertOrder(Orders order);
    void updateOrder(Orders order);
    void deleteOrder(int orderId);
}
