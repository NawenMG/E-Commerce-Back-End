package com.my_app.my_app.dbrel.JPA.Repository.Inizializzazione;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my_app.my_app.dbrel.JPA.Entity.Returns;
import com.my_app.my_app.dbrel.JPA.Repository.Interfaceeee.ReturnsRepI;

@Repository
public interface ReturnsS extends JpaRepository<Returns, Integer>, ReturnsRepI {
}
