package com.my_app.my_app.dbrel.JDBC.servicee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import com.my_app.my_app.dbrel.JDBC.model.Payments;
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryPayments;
import com.my_app.my_app.dbrel.JDBC.repository.interfacee.PaymentsRepI;

@Service
public class PaymentsSer {

    @Autowired
    private PaymentsRepI paymentsRepI;

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public List<Payments> queryService(ParmQueryPayments parmQuery) {
        return paymentsRepI.query(parmQuery);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void saveAllService(int number) {
        paymentsRepI.saveAll(number);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void insertPaymentService(Payments payment) {
        paymentsRepI.insertPayment(payment);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void updatePaymentService(Payments payment) {
        paymentsRepI.updatePayment(payment);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void deletePaymentService(int paymentsId) {
        paymentsRepI.deletePayment(paymentsId);
    }
}

