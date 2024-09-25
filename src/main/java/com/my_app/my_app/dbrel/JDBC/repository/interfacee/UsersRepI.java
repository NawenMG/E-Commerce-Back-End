package com.my_app.my_app.dbrel.JDBC.repository.interfacee;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.my_app.my_app.dbrel.JDBC.model.Users;
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryUsers;

@Repository
public interface UsersRepI {

    List<Users> query(ParmQueryUsers parmQuery);
    void saveAll(int number);
    void insertUser(Users user);
    void updateUser(Users user);
    void deleteUser(int userId);
}
