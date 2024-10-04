package com.my_app.my_app.dbKey.API.GraphQl.Controllers;

import com.my_app.my_app.dbKey.Models.WishList;
import com.my_app.my_app.dbKey.Parametri.ParamQuery;
import com.my_app.my_app.dbKey.Repository.Classss.WishListRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class WishListControllerGraphql {
    
    @Autowired
    private WishListRep wishListRep;    

    @QueryMapping
    public List<WishList> getWishList(@Argument ParamQuery params) {
        return wishListRep.search(params);
    }
}
