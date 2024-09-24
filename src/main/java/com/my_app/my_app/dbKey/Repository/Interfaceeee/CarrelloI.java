package com.my_app.my_app.dbKey.Repository.Interfaceeee;

import com.my_app.my_app.dbKey.Models.Carrello;
import com.my_app.my_app.dbKey.Parametri.ParamQuery;

import java.util.List;

public interface CarrelloI {
    void saveOrUpdate(Carrello carrello);
    Carrello findById(int userID, int productID);
    void deleteById(int userID, int productID);
    List<Carrello> search(ParamQuery paramQuery);
}
