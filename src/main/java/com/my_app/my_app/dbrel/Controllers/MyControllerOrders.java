package com.my_app.my_app.dbrel.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.my_app.my_app.dbrel.model.Orders;
import com.my_app.my_app.dbrel.parametri.ParmQueryOrders;
import com.my_app.my_app.dbrel.servicee.OrdersSer;

@RestController
@RequestMapping("/orders")
public class MyControllerOrders {

    @SuppressWarnings("unused")
    @Autowired
    private ParmQueryOrders parmQueryOrders;
    
    @Autowired
    private OrdersSer ordersSer;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Orders!";
    }

    // Query
    @PostMapping("/query")
    @ResponseBody
    public List<Orders> query(@RequestBody ParmQueryOrders parmQuery) {
        return ordersSer.queryService(parmQuery);
    }

    // Insert
    @PostMapping("/insert")
    @ResponseBody
    public String createOrder(@RequestBody Orders order) {
        ordersSer.insertOrderService(order);
        return "Order created successfully!";
    }

    // Update
    @PutMapping("/update/{orderId}")
    @ResponseBody
    public String updateOrder(@PathVariable int orderId, @RequestBody Orders order) {
        order.setOrderID(orderId);
        ordersSer.updateOrderService(order);
        return "Order updated successfully!";
    }

    // Delete
    @DeleteMapping("/delete/{orderId}")
    @ResponseBody
    public String deleteOrder(@PathVariable int orderId) {
        ordersSer.deleteOrderService(orderId);
        return "Order deleted successfully!";
    }

    // Faker per generare dati
    @PostMapping("/faker/{numberOfOrders}")
    @ResponseBody
    public String generateOrders(@PathVariable int numberOfOrders) {
        ordersSer.saveAllService(numberOfOrders);
        return "Orders generated and saved successfully!";
    }
}
