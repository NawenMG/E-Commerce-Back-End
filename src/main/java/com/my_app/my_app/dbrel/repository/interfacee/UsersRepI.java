package com.my_app.my_app.dbrel.repository.interfacee;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.my_app.my_app.dbrel.model.Users;
import com.my_app.my_app.dbrel.parametri.ParmQueryUsers;

@Repository
public interface UsersRepI {

    List<Users> query(ParmQueryUsers parmQuery);
    void saveAll(List<Users> users);
    void insertUser(Users user);
    void updateUser(Users user);
    void deleteUser(int userId);
}
