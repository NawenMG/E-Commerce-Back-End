package com.my_app.my_app.dbrel.JDBC.servicee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import com.my_app.my_app.dbrel.JDBC.model.Users;
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryUsers;
import com.my_app.my_app.dbrel.JDBC.repository.interfacee.UsersRepI;

@Service
public class UsersSer {

    @Autowired
    private UsersRepI usersRepI;

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public List<Users> queryService(ParmQueryUsers parmQuery) {
        return usersRepI.query(parmQuery);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void saveAllService(int number) {
        usersRepI.saveAll(number);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void insertUserService(Users user) {
        usersRepI.insertUser(user);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void updateUserService(Users user) {
        usersRepI.updateUser(user);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void deleteUserService(int userId) {
        usersRepI.deleteUser(userId);
    }
}

