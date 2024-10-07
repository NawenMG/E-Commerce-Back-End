package com.my_app.my_app.dbTS.API.Soap.AnalysisUser.Services.Interfacceeeeeee;

import com.my_app.my_app.dbTS.Models.AnalysisUser;
import com.my_app.my_app.dbTS.Parametri.ParamQuery;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public interface AnalysisUserServiceSoapI {

    @WebMethod
    List<AnalysisUser> getUsers(ParamQuery paramQuery);

    @WebMethod
    void insertUser(AnalysisUser user);

    @WebMethod
    void updateUser(AnalysisUser user);

    @WebMethod
    void deleteUser(String measurement, String user, long startTime, long endTime);
}
