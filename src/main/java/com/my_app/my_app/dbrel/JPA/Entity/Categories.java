package com.my_app.my_app.dbrel.JPA.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;;

@Entity
@Table(name = "Categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "Obbligatorio")
    private int CategoriesID;


    @NotBlank(message = "Obbligatorio")
    private String Name;

    // Costruttore di default
    public Categories() {}

    // Costruttore con parametri
    public Categories(String name) {
        Name = name;
    }

    // Getters e setters
    public int getCategoriesID() {
        return CategoriesID;
    }

    public void setCategoriesID(int categoriesID) {
        CategoriesID = categoriesID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
