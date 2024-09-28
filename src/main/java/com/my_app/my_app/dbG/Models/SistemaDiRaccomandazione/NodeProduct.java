package com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import jakarta.validation.constraints.NotBlank;



@Node
public class NodeProduct {
    @Id
    @NotBlank(message = "Obbligatorio")
    private String productId;

    @NotBlank(message = "Obbligatorio")
    private String name;

    @NotBlank(message = "Obbligatorio")
    private double price;

    // Relazione con la categoria del prodotto, belongs_to indica la categoria di appartenenza di un prodotto
    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.OUTGOING) //outgoing dal nodo sorgente al nodo destinazione
    private NodeCategoryProduct category;


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public NodeCategoryProduct getCategory() {
        return category;
    }

    public void setCategory(NodeCategoryProduct category) {
        this.category = category;
    }
}
