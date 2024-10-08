package com.my_app.my_app.dbrel.JPA.Controllers;

import com.my_app.my_app.dbrel.JPA.Entity.Categories;
import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;
import com.my_app.my_app.dbrel.JPA.Servicee.CategoriesSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jpa/api/categories")
public class MyControllerCategories {

    @Autowired
    private CategoriesSer categoriesSer;

    // Endpoint per ottenere le categorie
    @GetMapping("jpa/query")
    public ResponseEntity<List<Categories>> query(@RequestBody ParamQueryJpa paramQuery) {
        List<Categories> categories = categoriesSer.query(paramQuery);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    // Endpoint per inserire una nuova categoria
    @PostMapping("jpa/insert")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> insert(@RequestBody Categories categories) {
        categoriesSer.insert(categories);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Endpoint per aggiornare una categoria esistente
    @PutMapping("jpa/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> update(@RequestBody Categories categories) {
        categoriesSer.update(categories);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint per eliminare una categoria per ID
    @DeleteMapping("jpa/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        categoriesSer.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
