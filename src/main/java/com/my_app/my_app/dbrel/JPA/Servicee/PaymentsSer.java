package com.my_app.my_app.dbrel.JPA.Servicee;

import com.my_app.my_app.dbrel.JPA.Entity.Payments;
import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;
import com.my_app.my_app.dbrel.JPA.Repository.Classss.PaymentsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentsSer {

    @Autowired
    private PaymentsRep paymentsRep;

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public List<Payments> query(ParamQueryJpa paramQuery) {
        return paymentsRep.query(paramQuery);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void insert(Payments payment) {
        paymentsRep.insert(payment);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void update(Payments payment) {
        paymentsRep.update(payment);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void delete(Integer id) {
        paymentsRep.delete(id);
    }
}
