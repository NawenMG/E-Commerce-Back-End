package com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@Node
public class NodeUser {
    @Id
    private String userId;
    private String name;
    private String email;
    private String location;

    // Relazione con i prodotti acquistati, purchased: un utente acquista il prodotto
    @Relationship(type = "PURCHASED", direction = Relationship.Direction.OUTGOING)
    private Set<NodeProduct> purchasedProducts = new HashSet<>();

    // Relazione con i prodotti visitati, visited: un utente visita il prodotto
    @Relationship(type = "VISITED", direction = Relationship.Direction.OUTGOING)
    private Set<NodeProduct> visitedProducts = new HashSet<>();
    
    //Relazione locazione e user, located_in: indica la locazione dell'utente 
    @Relationship(type = "LOCATED_IN", direction = Relationship.Direction.OUTGOING)
    private NodeUserLocation nodeUserLocation;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<NodeProduct> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(Set<NodeProduct> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }

    public Set<NodeProduct> getVisitedProducts() {
        return visitedProducts;
    }

    public void setVisitedProducts(Set<NodeProduct> visitedProducts) {
        this.visitedProducts = visitedProducts;
    }

    public void addPurchasedProduct(NodeProduct product) {
        this.purchasedProducts.add(product);
    }

    public void addVisitedProduct(NodeProduct product) {
        this.visitedProducts.add(product);
    }

    public NodeUserLocation getnNodeUserLocation(){
        return nodeUserLocation;
    }

    public void setNodeUserLocation(NodeUserLocation nodeUserLocation){
        this.nodeUserLocation = nodeUserLocation;

    }
}
