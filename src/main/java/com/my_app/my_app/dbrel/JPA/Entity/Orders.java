package com.my_app.my_app.dbrel.JPA.Entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "Orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int OrderID;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "ProductID", nullable = false)
    private Products product;

    private int Quantity;
    private LocalDate OrderDate;
    private String Status;

    // Costruttore di default
    public Orders() {}

    // Costruttore con parametri
    public Orders(Users user, Products product, int quantity, LocalDate orderDate, String status) {
        this.user = user;
        this.product = product;
        Quantity = quantity;
        OrderDate = orderDate;
        Status = status;
    }

    // Getters e setters
    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public LocalDate getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        OrderDate = orderDate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
