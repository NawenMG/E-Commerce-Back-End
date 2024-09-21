package com.my_app.my_app.dbrel.JPA.Repository.Interfaceeee;

import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;
import com.my_app.my_app.dbrel.JPA.Entity.Returns;

import java.util.List;

public interface ReturnsRepI {
    List<Returns> query(ParamQueryJpa paramQueryJpa);
    void insert(Returns returns);
    void update(Returns returns);
    void delete(Integer id);
    
}