package com.my_app.my_app.dbCol.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.my_app.my_app.dbCol.Models.ArchiviazioneTransizioni;
import com.my_app.my_app.dbCol.Parametri.ParamQuery;
import com.my_app.my_app.dbCol.Services.ArchiviazioneTransizioniSer;

@RestController
@RequestMapping("/api/col/transizioni")
public class MyControllerArchiviazioneTransizioni {

    @Autowired
    private ArchiviazioneTransizioniSer archiviazioneTransizioniSer;

    @GetMapping("/query")
    public List<ArchiviazioneTransizioni> getTransizioni(ParamQuery paramQuery) {
        return archiviazioneTransizioniSer.query(paramQuery);
    }

    @PostMapping("/insert")
    public void createTransizione(@RequestBody ArchiviazioneTransizioni transizioni) {
        archiviazioneTransizioniSer.insertOrdine(transizioni);
    }

    @PutMapping("/update")
    public void updateTransizione(@RequestBody ArchiviazioneTransizioni transizioni) {
        archiviazioneTransizioniSer.updateOrdine(transizioni);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTransizione(@PathVariable int id) {
        archiviazioneTransizioniSer.deleteOrdine(id);
    }
}
