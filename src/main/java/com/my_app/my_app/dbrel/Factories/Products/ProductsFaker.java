package com.my_app.my_app.factory;

import com.github.javafaker.Faker;
import com.my_app.my_app.dbrel.model.Products;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductsFactory {
    private static final Faker faker = new Faker();

    public static List<Products> createProducts(int numberOfProducts) {
        List<Products> productsList = new ArrayList<>();

        for (int i = 0; i < numberOfProducts; i++) {
            Products product = new Products(
                0,  // productId sarà gestito dal database, quindi può essere 0 o non specificato
                faker.commerce().productName(),  // Nome
                Double.parseDouble(faker.commerce().price(1.0, 1000000.0)),  // Prezzo
                faker.lorem().sentence(10),  // Descrizione
                faker.image().imageUrl(),  // Immagine (URL dell'immagine)
                faker.number().numberBetween(1, 1000),  // AmountAvailable
                faker.commerce().department(),  // Categoria
                LocalDate.now()  // DataDiInserimento
            );
            productsList.add(product);
        }

        return productsList;
    }
}
