package com.my_app.my_app.dbrel.JPA.Repository.Inizializzazione;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my_app.my_app.dbrel.JPA.Entity.Users;
import com.my_app.my_app.dbrel.JPA.Repository.Interfaceeee.UsersRepI;

@Repository
public interface UsersS extends JpaRepository<Users, Integer>, UsersRepI {
}
