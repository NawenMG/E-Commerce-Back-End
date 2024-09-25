package com.my_app.my_app.dbRT.Collections;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.my_app.my_app.dbRT.Collections.PerSisNot.Notifica;

public class SistemaNotifiche {
    @Autowired Notifica notifica;
    private List<Notifica> notifiche;  

    // Costruttore
    public SistemaNotifiche() {
    }

    // Getters e Setters
    public List<Notifica> getNotifiche() {
        return notifiche;
    }

    public void addNotifica(Notifica notifica) {
        this.notifiche.add(notifica);  
    }
}


