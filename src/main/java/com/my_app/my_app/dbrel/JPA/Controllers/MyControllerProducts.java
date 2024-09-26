package com.my_app.my_app.dbrel.JPA.Controllers;

import com.my_app.my_app.dbrel.JPA.Entity.Products;
import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;
import com.my_app.my_app.dbrel.JPA.Servicee.ProductsSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jpa/api/products")
public class MyControllerProducts {

    @Autowired
    private ProductsSer productsSer;

    // Endpoint per ottenere i prodotti
    @GetMapping("jpa/query")
    public ResponseEntity<List<Products>> query(@RequestBody ParamQueryJpa paramQuery) {
        List<Products> products = productsSer.query(paramQuery);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Endpoint per inserire un nuovo prodotto
    @PostMapping("jpa/insert")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Void> insert(@RequestBody Products product) {
        productsSer.insert(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Endpoint per aggiornare un prodotto esistente
    @PutMapping("jpa/update")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Void> update(@RequestBody Products product) {
        productsSer.update(product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint per eliminare un prodotto per ID
    @DeleteMapping("jpa/delete/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        productsSer.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
