package com.my_app.my_app.dbrel.JPA.Repository.Interfaceeee;

import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;
import com.my_app.my_app.dbrel.JPA.Entity.Categories;

import java.util.List;

public interface CategoriesRepI {
    List<Categories> query(ParamQueryJpa paramQueryJpa);
    void insert(Categories categories);
    void update(Categories categories);
    void delete(Integer id);
    
}