package com.my_app.my_app.dbrel.JPA.Controllers;

import com.my_app.my_app.dbrel.JPA.Entity.Users;
import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;
import com.my_app.my_app.dbrel.JPA.Servicee.UsersSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jpa/api/users")
public class MyControllerUsers {

    @Autowired
    private UsersSer usersSer;

    // Endpoint per ottenere gli utenti
    @GetMapping("jpa/query")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Users>> query(@RequestBody ParamQueryJpa paramQuery) {
        List<Users> users = usersSer.query(paramQuery);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Endpoint per inserire un nuovo utente
    @PostMapping("jpa/insert")
    public ResponseEntity<Void> insert(@RequestBody Users user) {
        usersSer.insert(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Endpoint per aggiornare un utente esistente
    @PutMapping("jpa/update")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Void> update(@RequestBody Users user) {
        usersSer.update(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint per eliminare un utente per ID
    @DeleteMapping("jpa/delete/{id}")
    @PreAuthorize("hasRole('ADMIN', 'USER')")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        usersSer.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
