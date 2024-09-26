package com.my_app.my_app.dbCol.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.my_app.my_app.dbCol.Models.ArchiviazioneSegnalazioni;
import com.my_app.my_app.dbCol.Parametri.ParamQuery;
import com.my_app.my_app.dbCol.Repository.Interfaceeee.ArchiviazioneSegnalazioniI;

@Service
public class ArchiviazioneSegnalazioniSer {

    @Autowired
    private ArchiviazioneSegnalazioniI archiviazioneSegnalazioniRep;
    
    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public List<ArchiviazioneSegnalazioni> query(ParamQuery paramQuery) {
        return archiviazioneSegnalazioniRep.query(paramQuery);
    }
    
    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void insertOrdine(ArchiviazioneSegnalazioni segnalazioni) {
        archiviazioneSegnalazioniRep.insertOrdine(segnalazioni);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void updateOrdine(ArchiviazioneSegnalazioni segnalazioni) {
        archiviazioneSegnalazioniRep.updateOrdine(segnalazioni);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void deleteOrdine(int id) {
        archiviazioneSegnalazioniRep.deleteOrdine(id);
    }
}
