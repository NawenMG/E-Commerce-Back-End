package com.my_app.my_app.email.API.RestFul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.my_app.my_app.dbrel.JDBC.model.Products;
import com.my_app.my_app.email.ServiceEmail;

@RestController
@RequestMapping("/api/email")
public class MyControllerEmail {

    @Autowired
    private ServiceEmail serviceEmail;

    @PostMapping("/product")
    public String sendProductEmail(@RequestBody Products product, @RequestParam String to, @RequestParam String subject) {

        try {
            serviceEmail.sendProductEmail(to, subject, product);
            return "Email inviata con successo a " + to;
        } catch (Exception e) {
            e.printStackTrace();
            return "Errore nell'invio dell'email: " + e.getMessage();
        }
    }
}
