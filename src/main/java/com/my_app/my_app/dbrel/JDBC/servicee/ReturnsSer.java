package com.my_app.my_app.dbrel.JDBC.servicee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import com.my_app.my_app.dbrel.JDBC.model.Returns;
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryReturns;
import com.my_app.my_app.dbrel.JDBC.repository.interfacee.ReturnsRepI;

@Service
public class ReturnsSer {

    @Autowired
    private ReturnsRepI returnsRepI;

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public List<Returns> queryService(ParmQueryReturns parmQuery) {
        return returnsRepI.query(parmQuery);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
     public void saveAllService(int number) {
        returnsRepI.saveAll(number);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void insertReturnService(Returns returns) {
        returnsRepI.insertReturn(returns);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void updateReturnService(Returns returns) {
        returnsRepI.updateReturn(returns);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void deleteReturnService(int returnsID) {
        returnsRepI.deleteReturn(returnsID);
    }
}
