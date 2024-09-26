package com.my_app.my_app.dbKey.Services;

import com.my_app.my_app.dbKey.Models.Carrello;
import com.my_app.my_app.dbKey.Models.Settings;
import com.my_app.my_app.dbKey.Parametri.ParamQuery;
import com.my_app.my_app.dbKey.Repository.Classss.SettingsRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingsSer {
    
    @Autowired
    private SettingsRep settingsRep;

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public List<Settings> search(ParamQuery paramQuery) {
        return settingsRep.search(paramQuery);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void saveOrUpdate(Carrello carrello) {
        settingsRep.saveOrUpdate(carrello);
    }

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public Carrello findById(int userID, int productID) {
        return settingsRep.findById(userID, productID);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void deleteById(int userID, int productID) {
        settingsRep.deleteById(userID, productID);
    }
}
