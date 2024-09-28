package com.my_app.my_app.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.my_app.my_app.dbrel.JDBC.model.Products;

import freemarker.template.Configuration;
import freemarker.template.Template;

import jakarta.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceEmail {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Configuration freemarkerConfig;

    public void sendProductEmail(String to, String subject, Products product) throws Exception {
        // Prepara il messaggio MimeMessage
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

        // Imposta l'indirizzo del destinatario e l'oggetto dell'email
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setFrom("noreply@example.com");

        // Carica il template FreeMarker
        Template template = freemarkerConfig.getTemplate("productEmail.ftl");

        // Crea una mappa di dati da passare al template
        Map<String, Object> model = new HashMap<>();
        model.put("productId", product.getProductId());
        model.put("name", product.getNome());
        model.put("price", product.getPrezzo());
        model.put("description", product.getDescrizione());

        // Riempie il template con i dati passati tramite la mappa
        String htmlContent = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

        // Imposta il contenuto dell'email come HTML
        helper.setText(htmlContent, true); // Il parametro "true" indica che il messaggio è in formato HTML

        // Invia l'email
        mailSender.send(mimeMessage);
    }
}
