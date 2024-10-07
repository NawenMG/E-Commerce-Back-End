package com.my_app.my_app.dbKey.Services;

import com.my_app.my_app.dbKey.Models.Carrello;
import com.my_app.my_app.dbKey.Models.WishList;
import com.my_app.my_app.dbKey.Parametri.ParamQuery;
import com.my_app.my_app.dbKey.Repository.Classss.WishListRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListSer {
    
    @Autowired
    private WishListRep wishListRep;

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public List<WishList> search(ParamQuery paramQuery) {
        return wishListRep.search(paramQuery);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void saveOrUpdate(WishList wishList) {
        wishListRep.saveOrUpdate(wishList);
    }

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public Carrello findById(int userID, int productID) {
        return wishListRep.findById(userID, productID);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void deleteById(int userID, int productID) {
        wishListRep.deleteById(userID, productID);
    }
}
