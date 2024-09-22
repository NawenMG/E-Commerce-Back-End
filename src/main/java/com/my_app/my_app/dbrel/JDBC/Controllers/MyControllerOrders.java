package com.my_app.my_app.dbrel.JDBC.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.my_app.my_app.dbrel.JDBC.model.Orders;
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryOrders;
import com.my_app.my_app.dbrel.JDBC.servicee.OrdersSer;

@RestController
@RequestMapping("jdbc/orders")
public class MyControllerOrders {

    @SuppressWarnings("unused")
    @Autowired
    private ParmQueryOrders parmQueryOrders;
    
    @Autowired
    private OrdersSer ordersSer;

    @GetMapping("jdbc/hello")
    public String hello() {
        return "Hello, Orders!";
    }

    // Query
    @PostMapping("jdbc/query")
    @ResponseBody
    public List<Orders> query(@RequestBody ParmQueryOrders parmQuery) {
        return ordersSer.queryService(parmQuery);
    }

    // Insert
    @PostMapping("jdbc/insert")
    @ResponseBody
    public String createOrder(@RequestBody Orders order) {
        ordersSer.insertOrderService(order);
        return "Order created successfully!";
    }

    // Update
    @PutMapping("jdbc/update/{orderId}")
    @ResponseBody
    public String updateOrder(@PathVariable int orderId, @RequestBody Orders order) {
        order.setOrderID(orderId);
        ordersSer.updateOrderService(order);
        return "Order updated successfully!";
    }

    // Delete
    @DeleteMapping("jdbc/delete/{orderId}")
    @ResponseBody
    public String deleteOrder(@PathVariable int orderId) {
        ordersSer.deleteOrderService(orderId);
        return "Order deleted successfully!";
    }

    // Faker per generare dati
    @PostMapping("jdbc/faker/{numberOfOrders}")
    @ResponseBody
    public String generateOrders(@PathVariable int numberOfOrders) {
        ordersSer.saveAllService(numberOfOrders);
        return "Orders generated and saved successfully!";
    }
}
