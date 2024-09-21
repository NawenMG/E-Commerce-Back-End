package com.my_app.my_app.dbrel.JDBC.Factories.Random;

import com.github.javafaker.Faker;
import com.my_app.my_app.dbrel.JDBC.model.Products;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unused")
public class ProductsFaker {
    private static final Faker faker = new Faker();

    public static List<Products> createProducts(int numberOfProducts) {
        List<Products> productsList = new ArrayList<>();

        for (int i = 0; i < numberOfProducts; i++) {
            Products product = new Products(
    0,  // productId gestito dal database
              faker.commerce().productName(),  // Nome
              Double.parseDouble(faker.commerce().price(1.0, 1000000.0)),  // Prezzo
              faker.lorem().sentence(10),  // Descrizione
              faker.internet().image(),  // Immagine (URL)
              faker.number().numberBetween(1, 1000),  // AmountAvailable
              faker.commerce().department(),  // Categoria
              faker.date().past(365, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()  
);

            productsList.add(product);
        }

        return productsList;
    }
}
