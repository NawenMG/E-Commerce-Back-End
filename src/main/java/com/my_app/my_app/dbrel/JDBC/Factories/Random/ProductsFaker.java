package com.my_app.my_app.dbrel.JDBC.Factories.Random;

import com.github.javafaker.Faker;
import com.my_app.my_app.dbrel.JDBC.model.Products;

import java.time.LocalDate;

public class ProductsFaker {

    private Faker faker = new Faker();

    public Products generateFakeProduct(int number) {
        Products product = new Products();

        product.setProductId(faker.number().numberBetween(1, 10000));  // ID prodotto casuale
        product.setNome(faker.commerce().productName());               // Nome del prodotto
        product.setPrezzo(faker.number().randomDouble(2, 5, 1000));    // Prezzo del prodotto
        product.setDescrizione(faker.lorem().sentence(10));            // Descrizione casuale del prodotto
        product.setImmagine(faker.internet().avatar());                // Immagine casuale
        product.setAmountAvailable(faker.number().numberBetween(0, 100)); // Quantità disponibile casuale
        product.setCategoria(faker.commerce().department());           // Categoria del prodotto
        product.setDataDiInserimento(LocalDate.now().minusDays(faker.number().numberBetween(1, 365))); // Data di inserimento casuale

        return product; 
    }
}
