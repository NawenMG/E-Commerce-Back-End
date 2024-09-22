package com.my_app.my_app.dbrel.JPA.Repository.Inizializzazione;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my_app.my_app.dbrel.JPA.Entity.Orders;
import com.my_app.my_app.dbrel.JPA.Repository.Interfaceeee.OrdersRepI;

@Repository
public interface OrdersS extends JpaRepository<Orders, Integer>, OrdersRepI {
}
