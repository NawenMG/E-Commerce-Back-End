package com.my_app.my_app.dbDoc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.my_app.my_app.dbDoc.Collections.Recensioni;
import com.my_app.my_app.dbDoc.Repository.Classss.RecensioniRep;

import java.util.List;

@Service
public class RecensioniSer {

    @Autowired
    private RecensioniRep recensioniRep; 

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public List<Recensioni> query(Recensioni recensioni) {
        return recensioniRep.query(recensioni); 
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void insert(Recensioni recensioni) {
        recensioniRep.CustomInsert(recensioni); 
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void update(Recensioni recensioni) {
        recensioniRep.update(recensioni); 
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void delete(int idReview) {
        recensioniRep.delete(idReview); 
    }
}
