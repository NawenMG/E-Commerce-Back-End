package com.my_app.my_app.dbrel.JDBC.Factories.Random;

import com.github.javafaker.Faker;
import com.my_app.my_app.dbrel.JDBC.model.Orders;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unused")
public class OrdersFaker {
    private static final Faker faker = new Faker();

    public static List<Orders> createOrders(int numberOfOrders) {
        List<Orders> ordersList = new ArrayList<>();

        for (int i = 0; i < numberOfOrders; i++) {
            Orders order = new Orders(
                0, // orderID gestito dal database
                faker.number().numberBetween(1, 100), // usersID (simulando utenti esistenti)
                LocalTime.now(), // statoDiSpedizione (simulazione attuale)
                faker.date().future(30, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), // dataDiConsegna
                LocalDate.now(), // dataDiRichiesta
                faker.random().nextBoolean(), // accettazioneOrdine
                faker.random().nextBoolean(), // status
                faker.company().name(), // corriere
                faker.address().city() // posizione
            );

            ordersList.add(order);
        }

        return ordersList;
    }
}
