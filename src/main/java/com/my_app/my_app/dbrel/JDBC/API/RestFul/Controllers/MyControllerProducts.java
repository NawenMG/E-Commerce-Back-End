package com.my_app.my_app.dbrel.JDBC.API.RestFul.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.my_app.my_app.dbrel.JDBC.model.Products;
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryProducts;
import com.my_app.my_app.dbrel.JDBC.servicee.ProductsSer;

//Database relazionale MySql
//Controller Tabella Products
@RestController
@RequestMapping("jdbc/products")
public class MyControllerProducts {
    
    @Autowired
    private ParmQueryProducts parmQuery;
    @Autowired 
    private  ProductsSer productsSer;

    @GetMapping("jdbc/hello")
    public String hello() {
        return "ehi ciao";
    }
    //Query
    @PostMapping("jdbc/queryProducts")
    @ResponseBody
    public String invia(@RequestBody ParmQueryProducts parmQuery) {
        return "Dati inviati alla query";
    }
    @GetMapping("jdbc/queryProducts")
    @ResponseBody
    public List<Products> query() {
        List<Products> results = productsSer.queryService(parmQuery);
        return results;        
    }
    //Insert
    @PostMapping("jdbc/insertProducts")
    @PreAuthorize("hasRole('SELLER')")
    @ResponseBody
    public String createProduct(@RequestBody Products product) {
        productsSer.insertProductService(product);
        return "Product created successfully!";
    }
    //Update
    @PutMapping("jdbc/updateProducts/{productId}")
    @PreAuthorize("hasRole('SELLER')")
    @ResponseBody
    public String updateProduct(@PathVariable int productId, @RequestBody Products product) {
        product.setProductId(productId);  
        productsSer.updateProductService(product);
        return "Product updated successfully!";
    }
    //Delete
    @DeleteMapping("jdbc/deleteProducts/{productId}")
    @PreAuthorize("hasRole('SELLER')")
    @ResponseBody
    public String deleteProduct(@PathVariable int productId) {
        productsSer.deleteProductService(productId);
        return "Product deleted successfully!";
    }
    //Faker per inserire dei dati
    @PostMapping("jdbc/fakerProducts/{numberOfProducts}")
    @PreAuthorize("hasRole('SELLER')")
    @ResponseBody
    public String generateProducts(@PathVariable int numberOfProducts) { //Pathvariable quando immetti un parametro dall'url
        productsSer.saveAllService(numberOfProducts);
        return "Prodotti generati e salvati con successo!";
    }
}
