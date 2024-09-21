package com.my_app.my_app.dbrel.JPA.Controllers;

import com.my_app.my_app.dbrel.JPA.Entity.Payments;
import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;
import com.my_app.my_app.dbrel.JPA.Servicee.PaymentsSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class MyControllerPayments {

    @Autowired
    private PaymentsSer paymentsSer;

    // Endpoint per ottenere i pagamenti
    @PostMapping("/query")
    public ResponseEntity<List<Payments>> query(@RequestBody ParamQueryJpa paramQuery) {
        List<Payments> payments = paymentsSer.query(paramQuery);
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    // Endpoint per inserire un nuovo pagamento
    @PostMapping("/insert")
    public ResponseEntity<Void> insert(@RequestBody Payments payment) {
        paymentsSer.insert(payment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Endpoint per aggiornare un pagamento esistente
    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody Payments payment) {
        paymentsSer.update(payment);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint per eliminare un pagamento per ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        paymentsSer.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
