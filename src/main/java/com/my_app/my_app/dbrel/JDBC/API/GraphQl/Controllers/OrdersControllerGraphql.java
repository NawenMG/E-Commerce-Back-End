package com.my_app.my_app.dbrel.JDBC.API.GraphQl.Controllers;

import com.my_app.my_app.dbrel.JDBC.model.Orders; 
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryOrders;
import com.my_app.my_app.dbrel.JDBC.repository.classs.OrdersRep; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrdersControllerGraphql {

    @Autowired
    private OrdersRep ordersRep; 

    @QueryMapping
    public List<Orders> getOrders(@Argument ParmQueryOrders params) {
        return ordersRep.query(params);
    }
}
