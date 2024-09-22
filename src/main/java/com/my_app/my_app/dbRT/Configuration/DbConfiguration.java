package com.my_app.my_app.dbRT.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class DbConfiguration {
    @Bean
    public FirebaseApp initializeFirebase() throws IOException {
        try (FileInputStream serviceAccount = new FileInputStream("/my_app/src/main/resources/google-services.json")) {
            @SuppressWarnings("deprecation")
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://console.firebase.google.com/project/e-commerce-101b0/database/e-commerce-101b0-default-rtdb/data/~2F") // Cambia con il tuo URL del database
                    .build();

            return FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            System.err.println("Errore di inizializzazioen: " + e.getMessage());
            throw e; 
        }
    }
}
