package com.my_app.my_app.dbG.API.Soap.NodeUser.Services.Interfacceeeeeee;

import com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione.NodeUser;
import com.my_app.my_app.dbG.Parametri.ParamQuery;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public interface NodeUserServiceSoapI {

    @WebMethod
    List<NodeUser> getUsers(ParamQuery paramQuery);

    @WebMethod
    void insertUser(NodeUser user);

    @WebMethod
    void updateUser(NodeUser user);

    @WebMethod
    void deleteUser(String userId);
}
