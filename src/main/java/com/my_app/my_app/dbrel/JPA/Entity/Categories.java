package com.my_app.my_app.dbrel.JPA.Entity;

import jakarta.persistence.*;;

@Entity
@Table(name = "Categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CategoriesID;

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
