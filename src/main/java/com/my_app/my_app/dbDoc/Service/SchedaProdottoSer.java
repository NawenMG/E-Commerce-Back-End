package com.my_app.my_app.dbDoc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.my_app.my_app.dbDoc.Collections.SchedaProdotto;
import com.my_app.my_app.dbDoc.Repository.Classss.SchedaProdottoRep;

import java.util.List;

@Service
public class SchedaProdottoSer {

    @Autowired
    private SchedaProdottoRep schedaProdottoRep; // Inietta il repository

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public List<SchedaProdotto> query(SchedaProdotto schedaProdotto) {
        return schedaProdottoRep.query(schedaProdotto);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void insert(SchedaProdotto schedaProdotto) {
        schedaProdottoRep.CustomInsert(schedaProdotto);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void update(SchedaProdotto schedaProdotto) {
        schedaProdottoRep.update(schedaProdotto);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void delete(int idSchedaProdotto) {
        schedaProdottoRep.delete(idSchedaProdotto);
    }
}
