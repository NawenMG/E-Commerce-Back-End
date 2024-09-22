package com.my_app.my_app.dbrel.JPA.Repository.Inizializzazione;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my_app.my_app.dbrel.JPA.Entity.Payments;
import com.my_app.my_app.dbrel.JPA.Repository.Interfaceeee.PaymentsRepI;

@Repository
public interface PaymentsS extends JpaRepository<Payments, Integer>, PaymentsRepI {
}
