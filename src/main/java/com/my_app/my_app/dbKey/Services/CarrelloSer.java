package com.my_app.my_app.dbKey.Services;

import com.my_app.my_app.dbKey.Models.Carrello;
import com.my_app.my_app.dbKey.Parametri.ParamQuery;
import com.my_app.my_app.dbKey.Repository.Classss.CarrelloRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrelloSer {
    
    @Autowired
    private CarrelloRep carrelloRep;

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void saveOrUpdate(Carrello carrello) {
        carrelloRep.saveOrUpdate(carrello);
    }

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public Carrello findById(int userID, int productID) {
        return carrelloRep.findById(userID, productID);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void deleteById(int userID, int productID) {
        carrelloRep.deleteById(userID, productID);
    }

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public List<Carrello> search(ParamQuery paramQuery) {
        return carrelloRep.search(paramQuery);
    }
}
