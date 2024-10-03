package com.my_app.my_app.s3.API.RestFul.Controllers;

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
import com.my_app.my_app.dbCol.Models.ArchiviazioneSegnalazioni;
import com.my_app.my_app.s3.Services.s3Ser;

@RestController
@RequestMapping("s3/dbCol/archiviazionesegnalazioni")
@PreAuthorize("hasRole('ADMIN', 'CONTROLLER')")
public class MyControllerdbColArchiviazioneSegnalazioni {
    
     @Autowired
    private s3Ser s3Service;
    
    // Per inserire l'immagine in s3
    @PostMapping("/img/insert")
    public ResponseEntity<String> insertImg(@RequestParam MultipartFile imageFile) throws AmazonServiceException, SdkClientException, IOException {
        
        ArchiviazioneSegnalazioni archiviazioneSegnalazioni = new ArchiviazioneSegnalazioni(); 

        // Carica l'immagine su S3 e ottieni l'URL
        String imageUrl = s3Service.uploadMedia(imageFile);
        archiviazioneSegnalazioni.setImmagini(imageUrl);

        // Salva il prodotto nel database (usa un repository qui)
        return ResponseEntity.ok("Prodotto creato con successo");
    }

     // Endpoint per ottenere i dettagli del prodotto, inclusi i media
    @GetMapping("/img/query")
    public String getImmagine() {
        ArchiviazioneSegnalazioni archiviazioneSegnalazioni = new ArchiviazioneSegnalazioni();
        String immagine = archiviazioneSegnalazioni.getImmagini();
        return s3Service.getMediaUrl(immagine);
    }
    
    //Per inserire dei video
    @PostMapping("/video/insert")
    public ResponseEntity<String> insertVideo(@RequestParam MultipartFile videoFile) throws AmazonServiceException, SdkClientException, IOException {
        
        ArchiviazioneSegnalazioni archiviazioneSegnalazioni = new ArchiviazioneSegnalazioni(); 

        // Carica l'immagine su S3 e ottieni l'URL
        String videoUrl = s3Service.uploadMedia(videoFile);
        archiviazioneSegnalazioni.setVideo(videoUrl);

        // Salva il prodotto nel database (usa un repository qui)
        return ResponseEntity.ok("Prodotto creato con successo");
    }

    //Prendere video
    @GetMapping("/video/query")
    public String getVideo() {
        ArchiviazioneSegnalazioni archiviazioneSegnalazioni = new ArchiviazioneSegnalazioni();
        String video = archiviazioneSegnalazioni.getVideo();
        return s3Service.getMediaUrl(video);
    }

     //Per inserire dei video
     @PostMapping("/audio/insert")
     public ResponseEntity<String> insertAudio(@RequestParam MultipartFile audioFile) throws AmazonServiceException, SdkClientException, IOException {
         
         ArchiviazioneSegnalazioni archiviazioneSegnalazioni = new ArchiviazioneSegnalazioni(); 
 
         // Carica l'immagine su S3 e ottieni l'URL
         String audioUrl = s3Service.uploadMedia(audioFile);
         archiviazioneSegnalazioni.setAudio(audioUrl);
 
         // Salva il prodotto nel database (usa un repository qui)
         return ResponseEntity.ok("Prodotto creato con successo");
     }

      //Prendere video
    @GetMapping("/audio/query")
    public String getAudio() {
        ArchiviazioneSegnalazioni archiviazioneSegnalazioni = new ArchiviazioneSegnalazioni();
        String audio = archiviazioneSegnalazioni.getAudio();
        return s3Service.getMediaUrl(audio);
    }
}
