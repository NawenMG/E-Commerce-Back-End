package com.my_app.my_app.dbG.Controllers;

import com.my_app.my_app.dbG.Parametri.ParamQuery;
import com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione.NodeProduct;
import com.my_app.my_app.dbG.Services.ProductSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/g/products") 
@PreAuthorize("hasRole('ADMIN', 'CONTROLLER')")
public class MyControllerProduct {

    @Autowired
    private ProductSer productSer;

    // Endpoint per cercare prodotti
    @GetMapping("/query")
    public ResponseEntity<List<NodeProduct>> searchProducts(@RequestBody ParamQuery paramQuery) {
        List<NodeProduct> products = productSer.findByDynamicQuery(paramQuery);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Endpoint per inserire un nuovo prodotto
    @PostMapping("/insert")
    public ResponseEntity<Void> createProduct(@RequestBody NodeProduct product) {
        productSer.insertNodeProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Endpoint per aggiornare un prodotto esistente
    @PutMapping("/update/{productId}")
    public ResponseEntity<Void> updateProduct(@PathVariable String productId, @RequestBody NodeProduct product) {
        product.setProductId(productId); // Assicurati di impostare l'ID del prodotto per l'aggiornamento
        productSer.updateNodeProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Endpoint per eliminare un prodotto
    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String productId) {
        productSer.deleteNodeProduct(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
