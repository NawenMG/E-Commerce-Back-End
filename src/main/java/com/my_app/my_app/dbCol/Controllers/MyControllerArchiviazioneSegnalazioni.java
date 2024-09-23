package com.my_app.my_app.dbCol.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.my_app.my_app.dbCol.Models.ArchiviazioneSegnalazioni;
import com.my_app.my_app.dbCol.Parametri.ParamQuery;
import com.my_app.my_app.dbCol.Services.ArchiviazioneSegnalazioniSer;

@RestController
@RequestMapping("api/col/segnalazioni")
public class MyControllerArchiviazioneSegnalazioni {

    @Autowired
    private ArchiviazioneSegnalazioniSer archiviazioneSegnalazioniSer;

    @GetMapping("/query")
    public List<ArchiviazioneSegnalazioni> getSegnalazioni(ParamQuery paramQuery) {
        return archiviazioneSegnalazioniSer.query(paramQuery);
    }

    @PostMapping("/insert")
    public void createSegnalazione(@RequestBody ArchiviazioneSegnalazioni segnalazione) {
        archiviazioneSegnalazioniSer.insertOrdine(segnalazione);
    }

    @PutMapping("/update")
    public void updateSegnalazione(@RequestBody ArchiviazioneSegnalazioni segnalazione) {
        archiviazioneSegnalazioniSer.updateOrdine(segnalazione);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSegnalazione(@PathVariable int id) {
        archiviazioneSegnalazioniSer.deleteOrdine(id);
    }
}
