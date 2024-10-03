package com.my_app.my_app.dbG.API.RestFul.Controllers;

import com.my_app.my_app.dbG.Parametri.ParamQuery;
import com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione.NodeUser;
import com.my_app.my_app.dbG.Services.UserSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/g/users") 
@PreAuthorize("hasRole('ADMIN', 'CONTROLLER')")
public class MyControllerUser {

    @Autowired
    private UserSer userSer;

    // Endpoint per cercare gli utenti
    @GetMapping("/query")
    public ResponseEntity<List<NodeUser>> searchUsers(@RequestBody ParamQuery paramQuery) {
        List<NodeUser> users = userSer.findByDynamicQuery(paramQuery);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Endpoint per inserire un nuovo utente
    @PostMapping("/insert")
    public ResponseEntity<Void> createUser(@RequestBody NodeUser user) {
        userSer.insertNodeUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Endpoint per aggiornare un utente esistente
    @PutMapping("/update/{userId}")
    public ResponseEntity<Void> updateUser(@PathVariable String userId, @RequestBody NodeUser user) {
        user.setUserId(userId); // Assicurati di impostare l'ID dell'utente per l'aggiornamento
        userSer.updateNodeUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Endpoint per eliminare un utente
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        userSer.deleteNodeUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
