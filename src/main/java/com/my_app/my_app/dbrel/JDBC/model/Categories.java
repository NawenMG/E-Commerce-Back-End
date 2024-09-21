package com.my_app.my_app.dbrel.JDBC.model;

public class Categories {
    private int categoriesID;  // Chiave primaria
    private String name;       // Nome della categoria

    public Categories(int categoriesID, String name) {
        this.categoriesID = categoriesID;
        this.name = name;
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
