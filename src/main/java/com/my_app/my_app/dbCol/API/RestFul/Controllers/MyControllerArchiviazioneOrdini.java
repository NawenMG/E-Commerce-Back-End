package com.my_app.my_app.dbCol.API.RestFul.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.my_app.my_app.dbCol.Models.ArchiviazioneOrdini;
import com.my_app.my_app.dbCol.Parametri.ParamQuery;
import com.my_app.my_app.dbCol.Services.ArhciviazioneOrdiniSer;

@RestController
@RequestMapping("api/col/ordini")
@PreAuthorize("hasRole('DELIVERY')")

public class MyControllerArchiviazioneOrdini {

    @Autowired
    private ArhciviazioneOrdiniSer archiviazioneOrdiniSer;

    @GetMapping("/query")
    public List<ArchiviazioneOrdini> getOrdini(ParamQuery paramQuery) {
        return archiviazioneOrdiniSer.query(paramQuery);
    }

    @PostMapping("/insert")
    public void createOrdine(@RequestBody ArchiviazioneOrdini ordine) {
        archiviazioneOrdiniSer.insertOrdine(ordine);
    }

    @PutMapping("/update")
    public void updateOrdine(@RequestBody ArchiviazioneOrdini ordine) {
        archiviazioneOrdiniSer.updateOrdine(ordine);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrdine(@PathVariable int id) {
        archiviazioneOrdiniSer.deleteOrdine(id);
    }
}
