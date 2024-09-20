package com.my_app.my_app.dbrel.servicee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.my_app.my_app.dbrel.model.Categories;
import com.my_app.my_app.dbrel.parametri.ParmQueryCategories;
import com.my_app.my_app.dbrel.repository.interfacee.CategoriesRepI;

@Service
public class CategoriesSer {

    @Autowired
    private CategoriesRepI categoriesRepI;

    // Query
    public List<Categories> queryService(ParmQueryCategories parmQuery) {
        return categoriesRepI.query(parmQuery);
    }

    // Servizio per salvare tutte le categorie
    public void saveAllService(List<Categories> categories) {
        categoriesRepI.saveAll(categories);
    }

    // Insert
    public void insertCategoryService(Categories category) {
        categoriesRepI.insertCategory(category);
    }

    // Update
    public void updateCategoryService(Categories category) {
        categoriesRepI.updateCategory(category);
    }

    // Delete
    public void deleteCategoryService(int categoriesId) {
        categoriesRepI.deleteCategory(categoriesId);
    }
}

