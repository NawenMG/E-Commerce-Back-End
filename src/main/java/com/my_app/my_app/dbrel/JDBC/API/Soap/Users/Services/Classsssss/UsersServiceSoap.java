package com.my_app.my_app.dbrel.JDBC.API.Soap.Users.Services.Classsssss;

import com.my_app.my_app.dbrel.JDBC.model.Users;
import com.my_app.my_app.dbrel.JDBC.parametri.ParamQuery;
import com.my_app.my_app.dbrel.JDBC.repository.classs.UsersRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import jakarta.jws.WebService;
import java.util.List;

@Service
@WebService(endpointInterface = "com.my_app.my_app.dbG.API.Soap.Users.Services.Interfacceeeeeee.UsersServiceSoapI")
public class UsersServiceSoap implements com.my_app.my_app.dbrel.JDBC.API.Soap.Users.Services.Interfacceeeeeee.UsersServiceSoapI {

    @Autowired
    private UsersRep usersRep;

    @PreAuthorize("hasRole('USER')")
    public List<Users> getUsers(ParamQuery paramQuery) {
        return usersRep.query(paramQuery);
    }

    @PreAuthorize("hasRole('USER')")
    public void insertUser(Users user) {
        usersRep.insertUser(user);
    }


    @PreAuthorize("hasRole('USER')")
    public void updateUser(Users user) {
        usersRep.updateUser(user);
    }

    @PreAuthorize("hasRole('USER')")
    public void deleteUser(int userId) {
        usersRep.deleteUser(userId);
    }
}
