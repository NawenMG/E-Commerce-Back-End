package com.my_app.my_app.dbrel.JDBC.Factories.Random;

import com.github.javafaker.Faker;
import com.my_app.my_app.dbrel.JDBC.model.Users;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class UsersFaker {
    private static final Faker faker = new Faker();

    public static List<Users> createUsers(int numberOfUsers) {
        List<Users> usersList = new ArrayList<>();

        for (int i = 0; i < numberOfUsers; i++) {
            Users user = new Users(
                0,  // UsersID gestito dal database
                faker.name().firstName(),  // Nome
                faker.name().lastName(),  // Cognome
                faker.job().title(),  // Ruolo
                faker.name().username(),  // NomeUtente
                faker.internet().emailAddress(),  // Email
                faker.internet().password(),  // Password
                faker.internet().image(),  // Immagine (URL)
                faker.number().numberBetween(1, 10)  // Category (può essere modificato in base alla tua logica
            );

            usersList.add(user);
        }

        return usersList;
    }
}
