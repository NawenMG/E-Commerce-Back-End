package com.my_app.my_app.dbrel.JPA.Repository.Interfaceeee;

import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;
import com.my_app.my_app.dbrel.JPA.Entity.Users;

import java.util.List;

public interface UsersRepI {
    List<Users> query(ParamQueryJpa paramQueryJpa);
    void insert(Users users);
    void update(Users users);
    void delete(Integer id);
    
}