package com.my_app.my_app.dbrel.JPA.Repository.Interfaceeee;

import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;
import com.my_app.my_app.dbrel.JPA.Entity.Payments;

import java.util.List;

public interface PaymentsRepI {
    List<Payments> query(ParamQueryJpa paramQueryJpa);
    void insert(Payments payments);
    void update(Payments payments);
    void delete(Integer id);
    
}