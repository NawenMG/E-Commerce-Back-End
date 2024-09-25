package com.my_app.my_app.dbrel.JDBC.Factories.Random;

import com.github.javafaker.Faker;
import com.my_app.my_app.dbrel.JDBC.model.Categories;

public class CategoriesFaker {

    private Faker faker = new Faker();

    public Categories generateFakeCategory(int number) {
        Categories category = new Categories();

        category.setCategoriesID(faker.number().numberBetween(1, 1000)); // ID casuale
        category.setName(faker.commerce().department()); // Nome di una categoria fittizia

        return category; 
    }
}
