package com.my_app.my_app.dbKey.Models;

import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Settings")
public class Settings {
    private int userID;                // Partition Key
    private int settingID;             // Sort Key
    private int prodottiPerPagina;
    private String tema;
    private String layout;
    private String lingua;
    private Map<String, Boolean> notifiche;

    public Settings() {
    }

    @DynamoDBHashKey
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @DynamoDBRangeKey
    public int getSettingID() {
        return settingID;
    }

    public void setSettingID(int settingID) {
        this.settingID = settingID;
    }

    @DynamoDBAttribute
    public int getProdottiPerPagina() {
        return prodottiPerPagina;
    }

    public void setProdottiPerPagina(int prodottiPerPagina) {
        this.prodottiPerPagina = prodottiPerPagina;
    }

    @DynamoDBAttribute
    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @DynamoDBAttribute
    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    @DynamoDBAttribute
    public String getLingua() {
        return lingua;
    }

    public void setLingua(String lingua) {
        this.lingua = lingua;
    }

    @DynamoDBAttribute
    public Map<String, Boolean> getNotifiche() {
        return notifiche;
    }

    public void setNotifiche(Map<String, Boolean> notifiche) {
        this.notifiche = notifiche;
    }
}
