package com.my_app.my_app.dbrel.JDBC.API.Soap.Users.Services.Interfacceeeeeee;

import com.my_app.my_app.dbrel.JDBC.model.Users;
import com.my_app.my_app.dbrel.JDBC.parametri.ParamQuery;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public interface UsersServiceSoapI {

    @WebMethod
    List<Users> getUsers(ParamQuery paramQuery);

    @WebMethod
    void insertUser(Users user);

    @WebMethod
    void updateUser(Users user);

    @WebMethod
    void deleteUser(int userId);
}
