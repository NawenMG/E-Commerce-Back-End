package com.my_app.my_app.dbKey.Repository.Interfaceeee;

import com.my_app.my_app.dbKey.Models.Carrello;
import com.my_app.my_app.dbKey.Models.Settings;
import com.my_app.my_app.dbKey.Parametri.ParamQuery;

import java.util.List;

public interface SettingsI {
    
    List<Settings> search(ParamQuery paramQuery);
    
    void saveOrUpdate(Settings settings);
    
    Carrello findById(int userID, int productID);
    
    void deleteById(int userID, int productID);
}
