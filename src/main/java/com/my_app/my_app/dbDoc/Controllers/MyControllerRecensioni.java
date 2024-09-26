package com.my_app.my_app.dbDoc.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.my_app.my_app.dbDoc.Collections.Recensioni;
import com.my_app.my_app.dbDoc.Service.RecensioniSer;

import java.util.List;

@RestController
@RequestMapping("/api/doc/recensioni")
public class MyControllerRecensioni {

    @Autowired
    private RecensioniSer recensioniSer; 

    @GetMapping("/query")
    public List<Recensioni> query(Recensioni recensioni) {
        return recensioniSer.query(recensioni);
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('USER')")
    public void create(@RequestBody Recensioni recensioni) {
        recensioniSer.insert(recensioni); 
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('USER')")
    public void update(@RequestBody Recensioni recensioni) {
        recensioniSer.update(recensioni); 
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('USER')")
    public void delete(@PathVariable int id) {
        recensioniSer.delete(id); 
    }
}
