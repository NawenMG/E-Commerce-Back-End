package com.my_app.my_app.dbrel.JDBC.Factories.Random;

import com.github.javafaker.Faker;
import com.my_app.my_app.dbrel.JDBC.model.Users;

public class UsersFaker {

    private Faker faker = new Faker();

    public Users generateFakeUser() {
        Users user = new Users(); // Crea un'istanza vuota di Users

        // Usa i metodi setter per impostare i valori fittizi
        user.setUsersID(faker.number().numberBetween(1, 10000));          // ID utente casuale
        user.setNome(faker.name().firstName());                           // Nome casuale
        user.setCognome(faker.name().lastName());                         // Cognome casuale
        user.setRuolo(faker.job().position());                            // Ruolo casuale
        user.setNomeUtente(faker.internet().domainName());                  // Nome utente casuale
        user.setEmail(faker.internet().emailAddress());                   // Email casuale
        user.setPassword(faker.internet().password(8, 16));               // Password casuale tra 8 e 16 caratteri
        user.setImmagine(faker.internet().avatar());                      // Immagine avatar casuale
        user.setCategory(faker.number().numberBetween(1, 5));             // Categoria casuale tra 1 e 5

        return user; // Restituisce l'oggetto Users con i dati fittizi
    }
}
