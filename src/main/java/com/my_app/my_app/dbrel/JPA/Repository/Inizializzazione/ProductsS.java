package com.my_app.my_app.dbrel.JPA.Repository.Inizializzazione;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my_app.my_app.dbrel.JPA.Entity.Categories;
import com.my_app.my_app.dbrel.JPA.Repository.Interfaceeee.ProductsRepI;

@Repository
public interface ProductsS extends JpaRepository<Categories, Integer>, ProductsRepI {
}
