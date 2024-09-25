package com.my_app.my_app.dbrel.JDBC.Factories.Random;

import com.github.javafaker.Faker;
import com.my_app.my_app.dbrel.JDBC.model.Payments;

import java.time.LocalDate;
import java.util.List;

public class PaymentsFaker {

    private Faker faker = new Faker();

    public Payments generateFakePayment(int numbet) {
        Payments payment = new Payments(); 

        payment.setPaymentsID(faker.number().numberBetween(1, 10000));  // ID pagamento casuale
        payment.setType(faker.options().option("Credit Card", "PayPal", "Bank Transfer", "Cash")); // Tipo di pagamento
        payment.setData(LocalDate.now().minusDays(faker.number().numberBetween(1, 30))); // Data del pagamento
        payment.setStatus(faker.bool().bool());   // Stato del pagamento (true/false)
        payment.setTotal(faker.number().randomDouble(2, 10, 1000));  // Totale del pagamento casuale

        return payment;
    }

    public static List<Payments> createPayments(int numberOfPayments) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPayments'");
    }
}
