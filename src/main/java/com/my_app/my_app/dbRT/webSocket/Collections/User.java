package com.my_app.my_app.dbRT.webSocket.Collections;

public class User {
    private String userId;            // ID dell'utente
    private String username;          // Nome dell'utente
    private String profileImageUrl;   // URL dell'immagine profilo
    private boolean online;           // Stato dell'utente: online o offline

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
}
