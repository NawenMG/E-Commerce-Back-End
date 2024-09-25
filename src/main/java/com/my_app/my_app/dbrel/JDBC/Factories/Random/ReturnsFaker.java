package com.my_app.my_app.dbrel.JDBC.Factories.Random;

import com.github.javafaker.Faker;
import com.my_app.my_app.dbrel.JDBC.model.Returns;

import java.time.LocalDate;

public class ReturnsFaker {

    private Faker faker = new Faker();

    public Returns generateFakeReturn(int number) {
        Returns returnObject = new Returns(); 

        
        returnObject.setReturnsID(faker.number().numberBetween(1, 10000));          // ID del reso casuale
        returnObject.setUsersID(faker.number().numberBetween(1, 1000));             // ID utente casuale
        returnObject.setStatus(faker.bool().bool());                                // Stato del reso (true/false)
        returnObject.setAccettazioneReso(faker.bool().bool());                      // Accettazione del reso (true/false)
        returnObject.setDataRichiesta(LocalDate.now().minusDays(faker.number().numberBetween(1, 30))); // Data di richiesta casuale negli ultimi 30 giorni

        return returnObject; 
    }
}
