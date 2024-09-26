package com.my_app.my_app.dbrel.JPA.Controllers;

import com.my_app.my_app.dbrel.JPA.Entity.Returns;
import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;
import com.my_app.my_app.dbrel.JPA.Servicee.ReturnsSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jpa/api/returns")
public class MyControllerReturns {

    @Autowired
    private ReturnsSer returnsSer;

    // Endpoint per ottenere i dati dei ritorni
    @GetMapping("jpa/query")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Returns>> query(@RequestBody ParamQueryJpa paramQuery) {
        List<Returns> returns = returnsSer.query(paramQuery);
        return new ResponseEntity<>(returns, HttpStatus.OK);
    }

    // Endpoint per inserire un nuovo ritorno
    @PostMapping("jpa/insert")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> insert(@RequestBody Returns returns) {
        returnsSer.insert(returns);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Endpoint per aggiornare un ritorno esistente
    @PutMapping("jpa/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> update(@RequestBody Returns returns) {
        returnsSer.update(returns);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint per eliminare un ritorno per ID
    @DeleteMapping("jpa/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        returnsSer.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
