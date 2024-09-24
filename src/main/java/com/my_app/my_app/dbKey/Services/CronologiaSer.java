package com.my_app.my_app.dbKey.Services;

import com.my_app.my_app.dbKey.Models.Carrello;
import com.my_app.my_app.dbKey.Models.Cronologia;
import com.my_app.my_app.dbKey.Parametri.ParamQuery;
import com.my_app.my_app.dbKey.Repository.Classss.CronologiaRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CronologiaSer {

    @Autowired
    private CronologiaRep cronologiaRep;

    

    public List<Cronologia> search(ParamQuery paramQuery) {
        return cronologiaRep.search(paramQuery);
    }

    public void saveOrUpdate(Carrello carrello) {
        cronologiaRep.saveOrUpdate(carrello);
    }

    public Carrello findById(int userID, int productID) {
        return cronologiaRep.findById(userID, productID);
    }

    public void deleteById(int userID, int productID) {
        cronologiaRep.deleteById(userID, productID);
    }
}
