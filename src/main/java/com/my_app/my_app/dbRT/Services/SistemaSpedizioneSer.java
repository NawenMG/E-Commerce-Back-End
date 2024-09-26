package com.my_app.my_app.dbRT.Services;

import com.my_app.my_app.dbRT.Collections.SistemaSpedizione;
import com.my_app.my_app.dbRT.Parametri.ParamQuerySistemaSpedizione;
import com.my_app.my_app.dbRT.Repository.Interfaceeee.SistemaSpedizioneI;
import com.my_app.my_app.dbRT.Repository.Classs.SistemaSpedizioneRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class SistemaSpedizioneSer implements SistemaSpedizioneI {

    @Autowired
    private SistemaSpedizioneRep sistemaSpedizioneRep;

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public CompletableFuture<List<SistemaSpedizione>> queryChats(ParamQuerySistemaSpedizione paramQuerySistemaSpedizione) {
        return sistemaSpedizioneRep.queryChats(paramQuerySistemaSpedizione);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void insertChat(SistemaSpedizione sistemaSpedizione) {
        sistemaSpedizioneRep.insertChat(sistemaSpedizione);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void updateChat(String spedizioneID, SistemaSpedizione sistemaSpedizione) {
        sistemaSpedizioneRep.updateChat(spedizioneID, sistemaSpedizione);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void deleteChat(String spedizioneID) {
        sistemaSpedizioneRep.deleteChat(spedizioneID);
    }
}
