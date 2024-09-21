package com.my_app.my_app.dbrel.JDBC.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.my_app.my_app.dbrel.JDBC.model.Categories;
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryCategories;
import com.my_app.my_app.dbrel.JDBC.servicee.*;

@RestController
@RequestMapping("/categories")
public class MyControllerCategories {

    @SuppressWarnings("unused")
    @Autowired
    private ParmQueryCategories parmQuery;
    
    @Autowired
    private CategoriesSer categoriesSer;

    @GetMapping("/hello")
    public String hello() {
        return "Ciao da Categories!";
    }

    // Query
    @PostMapping("/query")
    @ResponseBody
    public List<Categories> query(@RequestBody ParmQueryCategories parmQuery) {
        return categoriesSer.queryService(parmQuery);
    }

    // Insert
    @PostMapping("/insert")
    @ResponseBody
    public String createCategory(@RequestBody Categories category) {
        categoriesSer.insertCategoryService(category);
        return "Categoria creata con successo!";
    }

    // Update
    @PutMapping("/update/{categoriesId}")
    @ResponseBody
    public String updateCategory(@PathVariable int categoriesId, @RequestBody Categories category) {
        category.setCategoriesID(categoriesId);
        categoriesSer.updateCategoryService(category);
        return "Categoria aggiornata con successo!";
    }

    // Delete
    @DeleteMapping("/delete/{categoriesId}")
    @ResponseBody
    public String deleteCategory(@PathVariable int categoriesId) {
        categoriesSer.deleteCategoryService(categoriesId);
        return "Categoria eliminata con successo!";
    }

    // Faker per inserire dati
    @PostMapping("/faker/{numberOfCategories}")
    @ResponseBody
    public String generateCategories(@PathVariable int numberOfCategories) {
        // Implementa la logica per generare e salvare categorie fittizie
        return "Categorie generate e salvate con successo!";
    }
}
