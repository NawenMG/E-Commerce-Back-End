package com.my_app.my_app.dbrel.JDBC.API.GraphQl.Controllers;

import com.my_app.my_app.dbrel.JDBC.model.Categories;
import com.my_app.my_app.dbrel.JDBC.parametri.ParamQuery;
import com.my_app.my_app.dbrel.JDBC.repository.classs.CategoriesRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CategoriesControllerGraphql {

    @Autowired
    private CategoriesRep categoriesRep;

    @QueryMapping
    public List<Categories> getCategories(@Argument ParamQuery params) {
        return categoriesRep.query(params);
    }
}
