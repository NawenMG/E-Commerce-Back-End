package com.my_app.my_app.dbrel.JPA.Servicee;

import com.my_app.my_app.dbrel.JPA.Entity.Categories;
import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;
import com.my_app.my_app.dbrel.JPA.Repository.Classss.CategoriesRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesSer {

    @Autowired
    private CategoriesRep categoriesRep;

    // Query per ottenere i dati in base ai parametri
    public List<Categories> query(ParamQueryJpa paramQuery) {
        return categoriesRep.query(paramQuery);
    }

    // Inserire un nuovo ritorno
    public void insert(Categories categories) {
        categoriesRep.insert(categories);
    }

    // Aggiornare un ritorno esistente
    public void update(Categories categories) {
        categoriesRep.update(categories);
    }

    // Eliminare un ritorno per ID
    public void delete(Integer id) {
        categoriesRep.delete(id);
    }
}