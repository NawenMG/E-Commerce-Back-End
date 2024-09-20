package com.my_app.my_app.dbrel.repository.interfacee;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.my_app.my_app.dbrel.model.Categories;
import com.my_app.my_app.dbrel.parametri.ParmQueryCategories;

@Repository
public interface CategoriesRepI {

    List<Categories> query(ParmQueryCategories parmQuery);
    void saveAll(List<Categories> categories);
    void insertCategory(Categories category);
    void updateCategory(Categories category);
    void deleteCategory(int categoriesId);
}
