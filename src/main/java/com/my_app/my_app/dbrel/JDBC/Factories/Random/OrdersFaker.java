package com.my_app.my_app.dbrel.JDBC.Factories.Random;

import com.github.javafaker.Faker;
import com.my_app.my_app.dbrel.JDBC.model.Orders;

import java.time.LocalDate;
import java.time.LocalTime;

public class OrdersFaker {

    private Faker faker = new Faker();

    public Orders generateFakeOrder(int number) {
        Orders order = new Orders(); 
        order.setOrderID(faker.number().numberBetween(1, 10000)); // ID ordine casuale
        order.setUsersID(faker.number().numberBetween(1, 1000));  // ID utente casuale
        order.setStatoDiSpedizione(LocalTime.now().minusHours(faker.number().numberBetween(1, 12))); // Stato di spedizione
        order.setDataDiConsegna(LocalDate.now().plusDays(faker.number().numberBetween(1, 10))); // Data di consegna fittizia
        order.setDataDiRichiesta(LocalDate.now().minusDays(faker.number().numberBetween(1, 10))); // Data di richiesta
        order.setAccettazioneOrdine(faker.bool().bool()); // Accettazione ordine (true/false)
        order.setStatus(faker.bool().bool());             // Stato dell'ordine (true/false)
        order.setCorriere(faker.company().name());        // Nome del corriere
        order.setPosizione(faker.address().cityName());   // Posizione dell'ordine

        return order; 
    }

    
}
