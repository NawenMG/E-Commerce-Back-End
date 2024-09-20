package com.my_app.my_app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.my_app.my_app.dbrel.model.Products;
import com.my_app.my_app.dbrel.parametri.ParmQuery;
import com.my_app.my_app.dbrel.repository.servicee.ProductsSer;


@RestController
public class MyController {
    
    @Autowired
    private ParmQuery parmQuery;
    @Autowired 
    private  ProductsSer productsSer;

    @GetMapping("/hello")
    public String hello() {
        return "ehi ciao";
    }

    //Database relazionale
    //Query
    @PostMapping("/query")
    public String invia(@RequestBody ParmQuery parmQuery) {
        return "Dati inviati alla query";
    }
    @GetMapping("/query")
    public List<Products> query() {
        List<Products> results = productsSer.queryService(parmQuery);
        return results;        
    }

    //Insert
    @PostMapping("/insert/")
    public String createProduct(@RequestBody Products product) {
        productsSer.insertProductService(product);
        return "Product created successfully!";
    }

    //Update
    @PutMapping("/update/{productId}")
    public String updateProduct(@PathVariable int productId, @RequestBody Products product) {
        product.setProductId(productId);  
        productsSer.updateProductService(product);
        return "Product updated successfully!";
    }

    //Delete
    @DeleteMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        productsSer.deleteProductService(productId);
        return "Product deleted successfully!";
    }

    //Faker per inserire dei dati
    @PostMapping("/generate-products")
    public String generateProducts(@RequestParam int numberOfProducts) {
        productsSer.saveAllService(numberOfProducts);
        return "Prodotti generati e salvati con successo!";
    }
}
