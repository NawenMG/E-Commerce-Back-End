package com.my_app.my_app.dbKey.API.Soap.Cronologia.Services.Interfacceeee;

import com.my_app.my_app.dbKey.Models.Cronologia;
import com.my_app.my_app.dbKey.Parametri.ParamQuery;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public interface CronologiaServiceSoapI {

    @WebMethod
    List<Cronologia> getCronologie(ParamQuery paramQuery);

    @WebMethod
    void insertCronologia(Cronologia cronologia);

    @WebMethod
    void updateCronologia(Cronologia cronologia);

    @WebMethod
    void deleteCronologia(int userId, int productId);
}
