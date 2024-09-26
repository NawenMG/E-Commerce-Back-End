package com.my_app.my_app.s3.Controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.my_app.my_app.dbRT.Collections.PerChat.Messaggio;
import com.my_app.my_app.s3.Services.s3Ser;

@RestController
@RequestMapping("s3/dbRel/chat/notifica")
@PreAuthorize("hasRole('ADMIN')")
public class MyControllerdbRTNotificaSistemaNotifiche {
    
     @Autowired
    private s3Ser s3Service;
    
    // Per inserire l'immagine in s3
    @PostMapping("/insert/immagine")
    public ResponseEntity<String> insertImmagine(@RequestParam MultipartFile imageFile) throws AmazonServiceException, SdkClientException, IOException {
        
        Messaggio messaggio = new Messaggio(); 
        // Carica l'immagine su S3 e ottieni l'URL
        String imageUrl = s3Service.uploadMedia(imageFile);
        messaggio.setImmagine(imageUrl);

        // Salva il prodotto nel database (usa un repository qui)
        return ResponseEntity.ok("Prodotto creato con successo");
    }

     // Endpoint per ottenere i dettagli del prodotto, inclusi i media
    @GetMapping("/query/immagine")
    public String getImmagine() {
        Messaggio messaggio = new Messaggio();
        String immagine = messaggio.getImmagine();
        return s3Service.getMediaUrl(immagine);
    }
}
