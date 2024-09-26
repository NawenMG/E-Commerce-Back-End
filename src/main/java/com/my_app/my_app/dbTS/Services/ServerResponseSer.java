package com.my_app.my_app.dbTS.Services;

import com.my_app.my_app.dbTS.Models.ServerResponse;
import com.my_app.my_app.dbTS.Parametri.ParamQuery;
import com.my_app.my_app.dbTS.Repository.Classss.ServerResponseRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServerResponseSer {

    @Autowired
    private ServerResponseRep serverResponseRep;

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public List<ServerResponse> query(ParamQuery paramQuery) {
        return serverResponseRep.query(paramQuery);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void insertServerResponse(ServerResponse serverResponse) {
        serverResponseRep.insertServerResponse(serverResponse);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void deleteData(String measurement, String server, long startTime, long endTime) {
        serverResponseRep.deleteData(measurement, server, startTime, endTime);
    }
}
