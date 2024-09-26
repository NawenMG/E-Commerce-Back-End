package com.my_app.my_app.dbrel.JDBC.servicee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import com.my_app.my_app.dbrel.JDBC.model.Categories;
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryCategories;
import com.my_app.my_app.dbrel.JDBC.repository.interfacee.CategoriesRepI;

@Service
public class CategoriesSer {

    @Autowired
    private CategoriesRepI categoriesRepI;

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public List<Categories> queryService(ParmQueryCategories parmQuery) {
        return categoriesRepI.query(parmQuery);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void saveAllService(int number) {
        categoriesRepI.saveAll(number);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void insertCategoryService(Categories category) {
        categoriesRepI.insertCategory(category);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void updateCategoryService(Categories category) {
        categoriesRepI.updateCategory(category);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void deleteCategoryService(int categoriesId) {
        categoriesRepI.deleteCategory(categoriesId);
    }
}

