package com.my_app.my_app.dbG.Services;

import com.my_app.my_app.dbG.Parametri.ParamQuery;
import com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione.NodeUserLocation;
import com.my_app.my_app.dbG.Repository.Classsss.UserLocationRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLocationSer {

    @Autowired
    private UserLocationRep userLocationRep;

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public List<NodeUserLocation> findByDynamicQuery(ParamQuery paramQuery) {
        return userLocationRep.findByDynamicQuery(paramQuery);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void insertNodeUserLocation(NodeUserLocation location) {
        userLocationRep.insertNodeUserLocation(location);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void updateNodeUserLocation(NodeUserLocation location) {
        userLocationRep.updateNodeUserLocation(location);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void deleteNodeUserLocation(String locationId) {
        userLocationRep.deleteNodeUserLocation(locationId);
    }
}
