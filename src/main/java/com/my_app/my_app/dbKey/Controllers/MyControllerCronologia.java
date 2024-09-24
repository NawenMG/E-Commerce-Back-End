package com.my_app.my_app.dbKey.Controllers;

import com.my_app.my_app.dbKey.Models.Carrello;
import com.my_app.my_app.dbKey.Models.Cronologia;
import com.my_app.my_app.dbKey.Parametri.ParamQuery;
import com.my_app.my_app.dbKey.Services.CronologiaSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/key/cronologia")
public class MyControllerCronologia {
    
    @Autowired
    private CronologiaSer cronologiaSer;


    @GetMapping("/query")
    public ResponseEntity<List<Cronologia>> search(@RequestBody ParamQuery paramQuery) {
        List<Cronologia> result = cronologiaSer.search(paramQuery);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/insert")
    public ResponseEntity<Void> saveOrUpdate(@RequestBody Carrello carrello) {
        cronologiaSer.saveOrUpdate(carrello);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{userID}/{productID}")
    public ResponseEntity<Carrello> findById(@PathVariable int userID, @PathVariable int productID) {
        Carrello carrello = cronologiaSer.findById(userID, productID);
        return ResponseEntity.ok(carrello);
    }

    @DeleteMapping("/delete/{userID}/{productID}")
    public ResponseEntity<Void> deleteById(@PathVariable int userID, @PathVariable int productID) {
        cronologiaSer.deleteById(userID, productID);
        return ResponseEntity.noContent().build();
    }
}
