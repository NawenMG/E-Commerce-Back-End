package com.my_app.my_app.dbrel.JDBC.servicee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.my_app.my_app.dbrel.JDBC.Factories.Random.UsersFaker;
import com.my_app.my_app.dbrel.JDBC.model.Users;
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryUsers;
import com.my_app.my_app.dbrel.JDBC.repository.interfacee.UsersRepI;

@Service
public class UsersSer {

    @Autowired
    private UsersRepI usersRepI;

    // Query
    public List<Users> queryService(ParmQueryUsers parmQuery) {
        return usersRepI.query(parmQuery);
    }

    // Servizio per il faker
    public void saveAllService(int numberOfUsers) {
        List<Users> users = UsersFaker.createUsers(numberOfUsers);
        usersRepI.saveAll(users);
    }

    // Insert
    public void insertUserService(Users user) {
        usersRepI.insertUser(user);
    }

    // Update
    public void updateUserService(Users user) {
        usersRepI.updateUser(user);
    }

    // Delete
    public void deleteUserService(int userId) {
        usersRepI.deleteUser(userId);
    }
}

