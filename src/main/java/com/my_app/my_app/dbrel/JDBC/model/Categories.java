package com.my_app.my_app.dbrel.JDBC.model;

import jakarta.validation.constraints.NotBlank;

public class Categories {
    @NotBlank(message = "Obbligatorio")
    private int categoriesID;  // Chiave primaria

    @NotBlank(message = "Obbligatorio")
    private String name;       // Nome della categoria

    public Categories() {
        
    }

    // Getter e Setter
    public int getCategoriesID() {
        return categoriesID;
    }

    public void setCategoriesID(int categoriesID) {
        this.categoriesID = categoriesID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
