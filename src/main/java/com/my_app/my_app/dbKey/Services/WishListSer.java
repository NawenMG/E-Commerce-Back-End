package com.my_app.my_app.dbKey.Services;

import com.my_app.my_app.dbKey.Models.Carrello;
import com.my_app.my_app.dbKey.Models.WishList;
import com.my_app.my_app.dbKey.Parametri.ParamQuery;
import com.my_app.my_app.dbKey.Repository.Classss.WishListRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListSer {
    
    @Autowired
    private WishListRep wishListRep;


    public List<WishList> search(ParamQuery paramQuery) {
        return wishListRep.search(paramQuery);
    }

    public void saveOrUpdate(Carrello carrello) {
        wishListRep.saveOrUpdate(carrello);
    }

    public Carrello findById(int userID, int productID) {
        return wishListRep.findById(userID, productID);
    }

    public void deleteById(int userID, int productID) {
        wishListRep.deleteById(userID, productID);
    }
}
