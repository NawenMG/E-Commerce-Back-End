package com.my_app.my_app.dbrel.JDBC.Factories.Random;

import com.github.javafaker.Faker;
import com.my_app.my_app.dbrel.JDBC.model.Returns;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReturnsFaker {
    private static final Faker faker = new Faker();

    public static List<Returns> createReturns(int numberOfReturns) {
        List<Returns> returnsList = new ArrayList<>();

        for (int i = 0; i < numberOfReturns; i++) {
            Returns returnItem = new Returns(
                0,  // returnsID gestito dal database
                faker.number().numberBetween(1, 100),  // usersID (esempio)
                faker.bool().bool(),  // status (booleano)
                faker.bool().bool(),  // accettazioneReso (booleano)
                LocalDate.now().minusDays(faker.number().numberBetween(1, 30))  // dataRichiesta (data recente)
            );

            returnsList.add(returnItem);
        }

        return returnsList;
    }
}
