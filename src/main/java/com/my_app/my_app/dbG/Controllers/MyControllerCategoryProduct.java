package com.my_app.my_app.dbG.Controllers;

import com.my_app.my_app.dbG.Parametri.ParamQuery;
import com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione.NodeCategoryProduct;
import com.my_app.my_app.dbG.Services.CategoryProductSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/g/categories") 
public class MyControllerCategoryProduct {

    @Autowired
    private CategoryProductSer categoryProductSer;

    // Endpoint per cercare categorie prodotto
    @GetMapping("/query")
    public ResponseEntity<List<NodeCategoryProduct>> searchCategories(@RequestBody ParamQuery paramQuery) {
        List<NodeCategoryProduct> categories = categoryProductSer.findByDynamicQuery(paramQuery);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    // Endpoint per inserire una nuova categoria prodotto
    @PostMapping("/insert")
    public ResponseEntity<Void> createCategory(@RequestBody NodeCategoryProduct categoryProduct) {
        categoryProductSer.insertNodeCategoryProduct(categoryProduct);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Endpoint per aggiornare una categoria prodotto esistente
    @PutMapping("/update/{categoryId}")
    public ResponseEntity<Void> updateCategory(@PathVariable String categoryId, @RequestBody NodeCategoryProduct categoryProduct) {
        categoryProduct.setCategoryId(categoryId); // Assicurati di impostare l'ID della categoria per l'aggiornamento
        categoryProductSer.updateNodeCategoryProduct(categoryProduct);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Endpoint per eliminare una categoria prodotto
    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable String categoryId) {
        categoryProductSer.deleteNodeCategoryProduct(categoryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
