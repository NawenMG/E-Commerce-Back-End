package com.my_app.my_app.dbrel.Factories.Random;

import com.github.javafaker.Faker;
import com.my_app.my_app.dbrel.model.Categories;

import java.util.ArrayList;
import java.util.List;

public class CategoriesFaker {
    private static final Faker faker = new Faker();

    public static List<Categories> createCategories(int numberOfCategories) {
        List<Categories> categoriesList = new ArrayList<>();

        for (int i = 0; i < numberOfCategories; i++) {
            Categories category = new Categories(
                0,  // categoriesID gestito dal database
                faker.commerce().department()  // Nome della categoria
            );

            categoriesList.add(category);
        }

        return categoriesList;
    }
}
