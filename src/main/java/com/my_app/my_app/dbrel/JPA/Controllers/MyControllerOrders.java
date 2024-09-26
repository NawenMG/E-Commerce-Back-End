package com.my_app.my_app.dbrel.JPA.Controllers;

import com.my_app.my_app.dbrel.JPA.Entity.Orders;
import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;
import com.my_app.my_app.dbrel.JPA.Servicee.OrdersSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jpa/api/orders")
public class MyControllerOrders {

    @Autowired
    private OrdersSer ordersSer;

    // Endpoint per ottenere gli ordini
    @GetMapping("jpa/query")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Orders>> query(@RequestBody ParamQueryJpa paramQuery) {
        List<Orders> orders = ordersSer.query(paramQuery);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    // Endpoint per inserire un nuovo ordine
    @PostMapping("jpa/insert")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> insert(@RequestBody Orders order) {
        ordersSer.insert(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Endpoint per aggiornare un ordine esistente
    @PutMapping("jpa/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> update(@RequestBody Orders order) {
        ordersSer.update(order);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint per eliminare un ordine per ID
    @DeleteMapping("jpa/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        ordersSer.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
