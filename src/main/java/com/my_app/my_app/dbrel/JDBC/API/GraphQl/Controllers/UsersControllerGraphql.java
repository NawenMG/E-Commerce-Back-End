package com.my_app.my_app.dbrel.JDBC.API.GraphQl.Controllers;

import com.my_app.my_app.dbrel.JDBC.model.Users; 
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryUsers;
import com.my_app.my_app.dbrel.JDBC.repository.classs.UsersRep; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UsersControllerGraphql {

    @Autowired
    private UsersRep usersRep; 

    @QueryMapping
    @PreAuthorize("hasRole('USER')")
    public List<Users> getUsers(@Argument ParmQueryUsers params) {
        return usersRep.query(params); 
    }
}
