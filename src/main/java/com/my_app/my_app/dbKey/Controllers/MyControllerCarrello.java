package com.my_app.my_app.dbKey.Controllers;

import com.my_app.my_app.dbKey.Models.Carrello;
import com.my_app.my_app.dbKey.Parametri.ParamQuery;
import com.my_app.my_app.dbKey.Services.CarrelloSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/key/carrello")
@PreAuthorize("hasRole('USER')")
public class MyControllerCarrello {
    
    @Autowired
    private CarrelloSer carrelloSer;


    @PostMapping("/insert")
    public ResponseEntity<Void> addOrUpdateCarrello(@RequestBody Carrello carrello) {
        carrelloSer.saveOrUpdate(carrello);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("get/{userID}/{productID}")
    public ResponseEntity<Carrello> getCarrello(@PathVariable int userID, @PathVariable int productID) {
        Carrello carrello = carrelloSer.findById(userID, productID);
        if (carrello == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carrello, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userID}/{productID}")
    public ResponseEntity<Void> deleteCarrello(@PathVariable int userID, @PathVariable int productID) {
        carrelloSer.deleteById(userID, productID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/query/search")
    public ResponseEntity<List<Carrello>> searchCarrelli(@RequestBody ParamQuery paramQuery) {
        List<Carrello> carrelli = carrelloSer.search(paramQuery);
        return new ResponseEntity<>(carrelli, HttpStatus.OK);
    }
}
