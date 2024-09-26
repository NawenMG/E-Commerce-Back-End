package com.my_app.my_app.dbKey.Controllers;

import com.my_app.my_app.dbKey.Models.Carrello;
import com.my_app.my_app.dbKey.Models.Settings;
import com.my_app.my_app.dbKey.Parametri.ParamQuery;
import com.my_app.my_app.dbKey.Services.SettingsSer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/key/settings")
@PreAuthorize("hasRole('USER')")
public class MyControllerSettings {
    
    @Autowired
    private SettingsSer settingsSer;


    @GetMapping("/query")
    public ResponseEntity<List<Settings>> search(@RequestBody ParamQuery paramQuery) {
        List<Settings> result = settingsSer.search(paramQuery);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/insert")
    public ResponseEntity<Void> saveOrUpdate(@RequestBody Carrello carrello) {
        settingsSer.saveOrUpdate(carrello);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{userID}/{productID}")
    public ResponseEntity<Carrello> findById(@PathVariable int userID, @PathVariable int productID) {
        Carrello carrello = settingsSer.findById(userID, productID);
        return ResponseEntity.ok(carrello);
    }

    @DeleteMapping("/delete/{userID}/{productID}")
    public ResponseEntity<Void> deleteById(@PathVariable int userID, @PathVariable int productID) {
        settingsSer.deleteById(userID, productID);
        return ResponseEntity.noContent().build();
    }
}
