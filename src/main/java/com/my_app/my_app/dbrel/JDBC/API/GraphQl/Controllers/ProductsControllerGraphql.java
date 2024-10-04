package com.my_app.my_app.dbrel.JDBC.API.GraphQl.Controllers;

import com.my_app.my_app.dbrel.JDBC.model.Products;
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryProducts;
import com.my_app.my_app.dbrel.JDBC.repository.classs.ProductsRep; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductsControllerGraphql {

    @Autowired
    private ProductsRep productsRep; 
    
    @QueryMapping
    public List<Products> getProducts(@Argument ParmQueryProducts params) {
        return productsRep.query(params); 
    }
}
