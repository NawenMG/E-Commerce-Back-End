package com.my_app.my_app.dbrel.Factories.Random;

import com.github.javafaker.Faker;
import com.my_app.my_app.dbrel.model.Payments;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PaymentsFaker {
    private static final Faker faker = new Faker();
    private static final String[] TYPES = {"Credit Card", "Debit Card", "PayPal", "Bank Transfer", "Gift Card"};

    public static List<Payments> createPayments(int numberOfPayments) {
        List<Payments> paymentsList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numberOfPayments; i++) {
            Payments payment = new Payments(
                0,  // paymentsID gestito dal database
                TYPES[random.nextInt(TYPES.length)],  // Tipo
                LocalDate.now().minusDays(faker.number().numberBetween(1, 365)),  // Data
                faker.random().nextBoolean(),  // Status
                Double.parseDouble(faker.commerce().price(1.0, 1000.0))  // Totale
            );

            paymentsList.add(payment);
        }

        return paymentsList;
    }
}
