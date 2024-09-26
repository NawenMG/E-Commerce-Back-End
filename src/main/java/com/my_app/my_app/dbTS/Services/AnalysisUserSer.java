package com.my_app.my_app.dbTS.Services;

import com.my_app.my_app.dbTS.Models.AnalysisUser;
import com.my_app.my_app.dbTS.Parametri.ParamQuery;
import com.my_app.my_app.dbTS.Repository.Classss.AnalysisUserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalysisUserSer {

    @Autowired
    private AnalysisUserRep analysisUserRep;

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public List<AnalysisUser> query(ParamQuery paramQuery) {
        return analysisUserRep.query(paramQuery);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void insertUser(AnalysisUser analysisUser) {
        analysisUserRep.insertUser(analysisUser);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void deleteData(String measurement, String user, long startTime, long endTime) {
        analysisUserRep.deleteData(measurement, user, startTime, endTime);
    }
}
