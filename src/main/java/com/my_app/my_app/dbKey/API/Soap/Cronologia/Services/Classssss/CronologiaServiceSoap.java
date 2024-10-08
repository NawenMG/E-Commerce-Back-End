package com.my_app.my_app.dbKey.API.Soap.Cronologia.Services.Classssss;

import com.my_app.my_app.dbKey.Models.Cronologia;
import com.my_app.my_app.dbKey.Parametri.ParamQuery;
import com.my_app.my_app.dbKey.Repository.Classss.CronologiaRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import jakarta.jws.WebService;
import java.util.List;

@Service
@WebService(endpointInterface = "com.my_app.my_app.dbG.API.Soap.Cronologia.Services.Interfacceeeeeee.CronologiaServiceSoapI")
public class CronologiaServiceSoap implements com.my_app.my_app.dbKey.API.Soap.Cronologia.Services.Interfacceeee.CronologiaServiceSoapI {

    @Autowired
    private CronologiaRep cronologiaRep;

    @PreAuthorize("hasRole('USER')")
    public List<Cronologia> getCronologie(ParamQuery paramQuery) {
        return cronologiaRep.search(paramQuery);
    }

    @PreAuthorize("hasRole('USER')")
    public void insertCronologia(Cronologia cronologia) {
        cronologiaRep.saveOrUpdate(cronologia);
    }

    @PreAuthorize("hasRole('USER')")
    public void updateCronologia(Cronologia cronologia) {
        cronologiaRep.saveOrUpdate(cronologia);
    }

    @PreAuthorize("hasRole('USER')")
    public void deleteCronologia(int userId, int productId) {
        cronologiaRep.deleteById(userId, productId);
    }
}
