package com.my_app.my_app.dbrel.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.my_app.my_app.dbrel.model.Payments;
import com.my_app.my_app.dbrel.parametri.ParmQueryPayments;
import com.my_app.my_app.dbrel.servicee.PaymentsSer;

@RestController
@RequestMapping("/payments")
public class MyControllerPayments {

    @SuppressWarnings("unused")
    @Autowired
    private ParmQueryPayments parmQueryPayments;
    
    @Autowired
    private PaymentsSer paymentsSer;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Payments!";
    }

    // Query
    @PostMapping("/query")
    @ResponseBody
    public List<Payments> query(@RequestBody ParmQueryPayments parmQuery) {
        return paymentsSer.queryService(parmQuery);
    }

    // Insert
    @PostMapping("/insert")
    @ResponseBody
    public String createPayment(@RequestBody Payments payment) {
        paymentsSer.insertPaymentService(payment);
        return "Payment created successfully!";
    }

    // Update
    @PutMapping("/update/{paymentsId}")
    @ResponseBody
    public String updatePayment(@PathVariable int paymentsId, @RequestBody Payments payment) {
        payment.setPaymentsID(paymentsId);  
        paymentsSer.updatePaymentService(payment);
        return "Payment updated successfully!";
    }

    // Delete
    @DeleteMapping("/delete/{paymentsId}")
    @ResponseBody
    public String deletePayment(@PathVariable int paymentsId) {
        paymentsSer.deletePaymentService(paymentsId);
        return "Payment deleted successfully!";
    }

    // Faker per generare dati
    @PostMapping("/faker/{numberOfPayments}")
    @ResponseBody
    public String generatePayments(@PathVariable int numberOfPayments) {
        paymentsSer.saveAllService(numberOfPayments);
        return "Payments generated and saved successfully!";
    }
}
