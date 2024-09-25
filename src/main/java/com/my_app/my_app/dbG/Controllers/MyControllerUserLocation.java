package com.my_app.my_app.dbG.Controllers;

import com.my_app.my_app.dbG.Parametri.ParamQuery;
import com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione.NodeUserLocation;
import com.my_app.my_app.dbG.Services.UserLocationSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/g/user-locations") 
public class MyControllerUserLocation {

    @Autowired
    private UserLocationSer userLocationSer;

    // Endpoint per cercare le localizzazioni utente
    @GetMapping("/query")
    public ResponseEntity<List<NodeUserLocation>> searchUserLocations(@RequestBody ParamQuery paramQuery) {
        List<NodeUserLocation> locations = userLocationSer.findByDynamicQuery(paramQuery);
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    // Endpoint per inserire una nuova localizzazione utente
    @PostMapping("/insert")
    public ResponseEntity<Void> createUserLocation(@RequestBody NodeUserLocation location) {
        userLocationSer.insertNodeUserLocation(location);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Endpoint per aggiornare una localizzazione utente esistente
    @PutMapping("/update/{locationId}")
    public ResponseEntity<Void> updateUserLocation(@PathVariable String locationId, @RequestBody NodeUserLocation location) {
        location.setLocationId(locationId); // Assicurati di impostare l'ID della localizzazione per l'aggiornamento
        userLocationSer.updateNodeUserLocation(location);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Endpoint per eliminare una localizzazione utente
    @DeleteMapping("/delete/{locationId}")
    public ResponseEntity<Void> deleteUserLocation(@PathVariable String locationId) {
        userLocationSer.deleteNodeUserLocation(locationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
