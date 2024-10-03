package com.my_app.my_app.dbRT.API.RestFul.Controllers;

import com.my_app.my_app.dbRT.Collections.SistemaNotifiche;
import com.my_app.my_app.dbRT.Parametri.ParamQuerySistemaNotifiche;
import com.my_app.my_app.dbRT.Services.SistemaNotificheSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/tr/notifiche")
@PreAuthorize("hasRole('ADMIN')")
public class MyControllerSistemaNotifiche {

    @Autowired
    private SistemaNotificheSer sistemaNotificheSer;

    // Endpoint per eseguire una query dinamica sulle notifiche
    @PostMapping("/query")
    public CompletableFuture<ResponseEntity<List<SistemaNotifiche>>> queryNotifiche(@RequestBody ParamQuerySistemaNotifiche paramQuerySistemaNotifiche) {
        return sistemaNotificheSer.queryChats(paramQuerySistemaNotifiche)
            .thenApply(notificheList -> new ResponseEntity<>(notificheList, HttpStatus.OK))
            .exceptionally(ex -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    // Endpoint per inserire una nuova notifica
    @PostMapping
    public ResponseEntity<Void> insertNotifica(@RequestBody SistemaNotifiche sistemaNotifiche) {
        sistemaNotificheSer.insertChat(sistemaNotifiche);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Endpoint per aggiornare una notifica esistente
    @PutMapping("/{notificaId}")
    public ResponseEntity<Void> updateNotifica(@PathVariable String notificaId, @RequestBody SistemaNotifiche sistemaNotifiche) {
        sistemaNotificheSer.updateChat(notificaId, sistemaNotifiche);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Endpoint per eliminare una notifica tramite il suo ID
    @DeleteMapping("/{notificaId}")
    public ResponseEntity<Void> deleteNotifica(@PathVariable String notificaId) {
        sistemaNotificheSer.deleteChat(notificaId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
