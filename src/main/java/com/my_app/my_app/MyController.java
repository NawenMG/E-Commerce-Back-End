package com.my_app.my_app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.my_app.my_app.dbrel.model.Products;
import com.my_app.my_app.dbrel.parametri.ParmQuery;
import com.my_app.my_app.dbrel.parametri.ParmQueryService;
import com.my_app.my_app.dbrel.repository.ProductsRep;
import com.my_app.my_app.dbrel.service.ProductsSer;

@RestController
public class MyController {
    
    @Autowired
    private ParmQueryService parmQueryService;
    @Autowired ProductsSer productsSer;

    @GetMapping("/hello")
    public String hello() {
        return "ehi ciao";
    }

    //Database relazionale
    //Query
    @PostMapping("/query/{parmQuery}")
    public String invia(@RequestBody ParmQuery parmQuery) {
        parmQueryService.processQuery(parmQuery);
        return "Dati inviati alla query";
    }
    @GetMapping("/query")
    public List<Products> query() {
        List<Products> results = productsSer.query(parmQueryService);
        return results;        
    }

    //Insert
    @PostMapping("/insert/")
    public String createProduct(@RequestBody Products product) {
        productsSer.createProduct(product);
        return "Product created successfully!";
    }

    //Update
    @PutMapping("/update/{productId}")
    public String updateProduct(@PathVariable int productId, @RequestBody Products product) {
        product.setProductId(productId);  
        productsSer.updateProduct(product);
        return "Product updated successfully!";
    }

    //Delete
    @DeleteMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        productsSer.deleteProduct(productId);
        return "Product deleted successfully!";
    }

    //Faker per inserire dei dati
    @PostMapping("/generate-products")
    public String generateProducts(@RequestParam int numberOfProducts) {
        productsSer.generateAndSaveProducts(numberOfProducts);
        return "Prodotti generati e salvati con successo!";
    }


}
