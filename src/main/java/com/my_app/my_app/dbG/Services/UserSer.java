package com.my_app.my_app.dbG.Services;

import com.my_app.my_app.dbG.Parametri.ParamQuery;
import com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione.NodeUser;
import com.my_app.my_app.dbG.Repository.Classsss.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSer {

    @Autowired
    private UserRep userRep;

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public List<NodeUser> findByDynamicQuery(ParamQuery paramQuery) {
        return userRep.findByDynamicQuery(paramQuery);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void insertNodeUser(NodeUser user) {
        userRep.insertNodeUser(user);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void updateNodeUser(NodeUser user) {
        userRep.updateNodeUser(user);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void deleteNodeUser(String userId) {
        userRep.deleteNodeUser(userId);
    }
}
