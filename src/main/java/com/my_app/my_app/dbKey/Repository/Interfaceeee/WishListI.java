package com.my_app.my_app.dbKey.Repository.Interfaceeee;

import com.my_app.my_app.dbKey.Models.Carrello;
import com.my_app.my_app.dbKey.Models.WishList;
import com.my_app.my_app.dbKey.Parametri.ParamQuery;

import java.util.List;

public interface WishListI {
    
    List<WishList> search(ParamQuery paramQuery);
    
    void saveOrUpdate(WishList wishList);
    
    Carrello findById(int userID, int productID);
    
    void deleteById(int userID, int productID);
}
