package com.my_app.my_app.dbrel.JPA.Controllers;

import com.my_app.my_app.dbrel.JPA.Entity.Payments;
import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;
import com.my_app.my_app.dbrel.JPA.Servicee.PaymentsSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jpa/api/payments")
public class MyControllerPayments {

    @Autowired
    private PaymentsSer paymentsSer;

    // Endpoint per ottenere i pagamenti
    @GetMapping("jpa/query")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Payments>> query(@RequestBody ParamQueryJpa paramQuery) {
        List<Payments> payments = paymentsSer.query(paramQuery);
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    // Endpoint per inserire un nuovo pagamento
    @PostMapping("jpa/insert")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> insert(@RequestBody Payments payment) {
        paymentsSer.insert(payment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Endpoint per aggiornare un pagamento esistente
    @PutMapping("jpa/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> update(@RequestBody Payments payment) {
        paymentsSer.update(payment);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint per eliminare un pagamento per ID
    @DeleteMapping("jpa/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        paymentsSer.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
