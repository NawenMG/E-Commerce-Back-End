package com.my_app.my_app.dbrel.JPA.Controllers;

import com.my_app.my_app.dbrel.JPA.Entity.Orders;
import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;
import com.my_app.my_app.dbrel.JPA.Servicee.OrdersSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class MyControllerOrders {

    @Autowired
    private OrdersSer ordersSer;

    // Endpoint per ottenere gli ordini
    @PostMapping("/query")
    public ResponseEntity<List<Orders>> query(@RequestBody ParamQueryJpa paramQuery) {
        List<Orders> orders = ordersSer.query(paramQuery);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    // Endpoint per inserire un nuovo ordine
    @PostMapping("/insert")
    public ResponseEntity<Void> insert(@RequestBody Orders order) {
        ordersSer.insert(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Endpoint per aggiornare un ordine esistente
    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody Orders order) {
        ordersSer.update(order);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint per eliminare un ordine per ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        ordersSer.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
