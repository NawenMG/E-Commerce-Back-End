package com.my_app.my_app.dbrel.JDBC.API.RestFul.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.my_app.my_app.dbrel.JDBC.model.Users;
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryUsers;
import com.my_app.my_app.dbrel.JDBC.servicee.UsersSer;

//Database relazionale MySql
//Controller Tabella Users
@RestController
@RequestMapping("jdbc/users")
public class MyControllerUsers {

    @Autowired
    private ParmQueryUsers parmQuery;
    @Autowired
    private UsersSer usersSer;

    @GetMapping("jdbc/hello")
    public String hello() {
        return "ehi ciao";
    }

    // Query
    @PostMapping("jdbc/queryUsers")
    @ResponseBody
    public String invia(@RequestBody ParmQueryUsers parmQuery) {
        return "Dati inviati alla query";
    }

    @GetMapping("jdbc/queryUsers")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseBody
    public List<Users> query() {
        List<Users> results = usersSer.queryService(parmQuery);
        return results;
    }

    // Insert
    @PostMapping("jdbc/insertUsers")
    @ResponseBody
    public String createUser(@RequestBody Users user) {
        usersSer.insertUserService(user);
        return "User created successfully!";
    }

    // Update
    @PutMapping("jdbc/updateUsers/{userId}")
    @PreAuthorize("hasRole('USER')")
    @ResponseBody
    public String updateUser(@PathVariable int userId, @RequestBody Users user) {
        user.setUsersID(userId);  
        usersSer.updateUserService(user);
        return "User updated successfully!";
    }

    // Delete
    @DeleteMapping("jdbc/deleteUsers/{userId}")
    @PreAuthorize("hasRole('USER', 'ADMIN')")
    @ResponseBody
    public String deleteUser(@PathVariable int userId) {
        usersSer.deleteUserService(userId);
        return "User deleted successfully!";
    }

    // Faker per inserire dei dati
    @PostMapping("/fakerUsers/{numberOfUsers}")
    @ResponseBody
    public String generateUsers(@PathVariable int numberOfUsers) {
        usersSer.saveAllService(numberOfUsers);
        return "Users generated and saved successfully!";
    }
}
