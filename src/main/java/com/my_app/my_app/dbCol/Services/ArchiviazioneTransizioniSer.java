package com.my_app.my_app.dbCol.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.my_app.my_app.dbCol.Models.ArchiviazioneTransizioni;
import com.my_app.my_app.dbCol.Parametri.ParamQuery;
import com.my_app.my_app.dbCol.Repository.Interfaceeee.ArchiviazioneTransizioniI;

@Service
public class ArchiviazioneTransizioniSer {

    @Autowired
    private ArchiviazioneTransizioniI archiviazioneTransizioniRep;
    
    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public List<ArchiviazioneTransizioni> query(ParamQuery paramQuery) {
        return archiviazioneTransizioniRep.query(paramQuery);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void insertOrdine(ArchiviazioneTransizioni transizioni) {
        archiviazioneTransizioniRep.insertOrdine(transizioni);
    }
    
    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void updateOrdine(ArchiviazioneTransizioni transizioni) {
        archiviazioneTransizioniRep.updateOrdine(transizioni);
    }
    
    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void deleteOrdine(int id) {
        archiviazioneTransizioniRep.deleteOrdine(id);
    }
}
