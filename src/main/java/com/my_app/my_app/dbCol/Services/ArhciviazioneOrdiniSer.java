package com.my_app.my_app.dbCol.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.my_app.my_app.dbCol.Models.ArchiviazioneOrdini;
import com.my_app.my_app.dbCol.Parametri.ParamQuery;
import com.my_app.my_app.dbCol.Repository.Interfaceeee.ArchiviazioneOrdiniI;

@Service
public class ArhciviazioneOrdiniSer {

    @Autowired
    private ArchiviazioneOrdiniI archiviazioneOrdiniRep;

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public List<ArchiviazioneOrdini> query(ParamQuery paramQuery) {
        return archiviazioneOrdiniRep.query(paramQuery);
    }
    
    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void insertOrdine(ArchiviazioneOrdini ordine) {
        archiviazioneOrdiniRep.insertOrdine(ordine);
    }
    
    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void updateOrdine(ArchiviazioneOrdini ordine) {
        archiviazioneOrdiniRep.updateOrdine(ordine);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void deleteOrdine(int id) {
        archiviazioneOrdiniRep.deleteOrdine(id);
    }
}
