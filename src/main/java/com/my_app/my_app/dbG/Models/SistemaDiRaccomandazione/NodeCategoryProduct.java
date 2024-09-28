package com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

import jakarta.validation.constraints.NotBlank;

@Node
public class NodeCategoryProduct {
    @Id
    @NotBlank(message = "Obbligatorio")
    private String categoryId;
    
    @NotBlank(message = "Obbligatorio")
    private String categoryName;


    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
