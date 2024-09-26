package com.my_app.my_app.dbRT.Controllers;

import com.my_app.my_app.dbRT.Collections.SistemaSpedizione;
import com.my_app.my_app.dbRT.Parametri.ParamQuerySistemaSpedizione;
import com.my_app.my_app.dbRT.Services.SistemaSpedizioneSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/rt/spedizioni")
@PreAuthorize("hasRole('DELIVERY')")
public class MyControllerSistemaSpedizione {

    @Autowired
    private SistemaSpedizioneSer sistemaSpedizioneSer;

    // Endpoint per eseguire una query dinamica sulle spedizioni
    @PostMapping("/query")
    public CompletableFuture<ResponseEntity<List<SistemaSpedizione>>> querySpedizioni(@RequestBody ParamQuerySistemaSpedizione paramQuerySistemaSpedizione) {
        return sistemaSpedizioneSer.queryChats(paramQuerySistemaSpedizione)
            .thenApply(spedizioniList -> new ResponseEntity<>(spedizioniList, HttpStatus.OK))
            .exceptionally(ex -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    // Endpoint per inserire una nuova spedizione
    @PostMapping
    public ResponseEntity<Void> insertSpedizione(@RequestBody SistemaSpedizione sistemaSpedizione) {
        sistemaSpedizioneSer.insertChat(sistemaSpedizione);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Endpoint per aggiornare una spedizione esistente
    @PutMapping("/{spedizioneId}")
    public ResponseEntity<Void> updateSpedizione(@PathVariable String spedizioneId, @RequestBody SistemaSpedizione sistemaSpedizione) {
        sistemaSpedizioneSer.updateChat(spedizioneId, sistemaSpedizione);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Endpoint per eliminare una spedizione tramite il suo ID
    @DeleteMapping("/{spedizioneId}")
    public ResponseEntity<Void> deleteSpedizione(@PathVariable String spedizioneId) {
        sistemaSpedizioneSer.deleteChat(spedizioneId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
