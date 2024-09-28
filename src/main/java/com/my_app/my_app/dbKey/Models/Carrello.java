package com.my_app.my_app.dbKey.Models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import jakarta.validation.constraints.NotBlank;

@DynamoDBTable(tableName = "Carrello")
public class Carrello {
    @NotBlank(message = "Obbligatorio")
    private int userID;         // Partition Key

    @NotBlank(message = "Obbligatorio")
    private int productID;      // Sort Key

    @NotBlank(message = "Obbligatorio")
    private String productName;

    @NotBlank(message = "Obbligatorio")
    private double productPrice;

    private String productImage;
    
    private String productText;

    @NotBlank(message = "Obbligatorio")
    private String productCompany;

    public Carrello() {
    }

    @DynamoDBHashKey
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @DynamoDBRangeKey
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @DynamoDBAttribute
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @DynamoDBAttribute
    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @DynamoDBAttribute
    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    @DynamoDBAttribute
    public String getProductText() {
        return productText;
    }

    public void setProductText(String productText) {
        this.productText = productText;
    }

    @DynamoDBAttribute
    public String getProductCompany() {
        return productCompany;
    }

    public void setProductCompany(String productCompany) {
        this.productCompany = productCompany;
    }
}
