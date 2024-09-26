package com.my_app.my_app.dbrel.JPA.Servicee;

import com.my_app.my_app.dbrel.JPA.Entity.Categories;
import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;
import com.my_app.my_app.dbrel.JPA.Repository.Classss.CategoriesRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesSer {

    @Autowired
    private CategoriesRep categoriesRep;

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public List<Categories> query(ParamQueryJpa paramQuery) {
        return categoriesRep.query(paramQuery);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void insert(Categories categories) {
        categoriesRep.insert(categories);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void update(Categories categories) {
        categoriesRep.update(categories);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void delete(Integer id) {
        categoriesRep.delete(id);
    }
}