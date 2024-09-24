package com.my_app.my_app.dbKey.Controllers;

import com.my_app.my_app.dbKey.Models.Carrello;
import com.my_app.my_app.dbKey.Models.WishList;
import com.my_app.my_app.dbKey.Parametri.ParamQuery;
import com.my_app.my_app.dbKey.Services.WishListSer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/key/wishlist")
public class MyControllerWishList {
    
    @Autowired
    private WishListSer wishListSer;


    @GetMapping("/query")
    public ResponseEntity<List<WishList>> search(@RequestBody ParamQuery paramQuery) {
        List<WishList> result = wishListSer.search(paramQuery);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/insert")
    public ResponseEntity<Void> saveOrUpdate(@RequestBody Carrello carrello) {
        wishListSer.saveOrUpdate(carrello);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{userID}/{productID}")
    public ResponseEntity<Carrello> findById(@PathVariable int userID, @PathVariable int productID) {
        Carrello carrello = wishListSer.findById(userID, productID);
        return ResponseEntity.ok(carrello);
    }

    @DeleteMapping("/delete/{userID}/{productID}")
    public ResponseEntity<Void> deleteById(@PathVariable int userID, @PathVariable int productID) {
        wishListSer.deleteById(userID, productID);
        return ResponseEntity.noContent().build();
    }
}
