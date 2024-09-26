package com.my_app.my_app.dbrel.JDBC.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.my_app.my_app.dbrel.JDBC.model.Payments;
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryPayments;
import com.my_app.my_app.dbrel.JDBC.servicee.PaymentsSer;

@RestController
@RequestMapping("jdbc/payments")
public class MyControllerPayments {

    @SuppressWarnings("unused")
    @Autowired
    private ParmQueryPayments parmQueryPayments;
    
    @Autowired
    private PaymentsSer paymentsSer;

    @GetMapping("jdbc/hello")
    public String hello() {
        return "Hello, Payments!";
    }

    // Query
    @PostMapping("jdbc/query")
    @ResponseBody
    public List<Payments> query(@RequestBody ParmQueryPayments parmQuery) {
        return paymentsSer.queryService(parmQuery);
    }

    // Insert
    @PostMapping("jdbc/insert")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseBody
    public String createPayment(@RequestBody Payments payment) {
        paymentsSer.insertPaymentService(payment);
        return "Payment created successfully!";
    }

    // Update
    @PutMapping("jdbc/update/{paymentsId}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseBody
    public String updatePayment(@PathVariable int paymentsId, @RequestBody Payments payment) {
        payment.setPaymentsID(paymentsId);  
        paymentsSer.updatePaymentService(payment);
        return "Payment updated successfully!";
    }

    // Delete
    @DeleteMapping("jdbc/delete/{paymentsId}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseBody
    public String deletePayment(@PathVariable int paymentsId) {
        paymentsSer.deletePaymentService(paymentsId);
        return "Payment deleted successfully!";
    }

    // Faker per generare dati
    @PostMapping("jdbc/faker/{numberOfPayments}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseBody
    public String generatePayments(@PathVariable int numberOfPayments) {
        paymentsSer.saveAllService(numberOfPayments);
        return "Payments generated and saved successfully!";
    }
}
