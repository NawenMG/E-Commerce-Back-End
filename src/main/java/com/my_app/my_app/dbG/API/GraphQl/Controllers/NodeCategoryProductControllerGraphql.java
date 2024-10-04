package com.my_app.my_app.dbG.API.GraphQl.Controllers;

import com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione.NodeCategoryProduct;
import com.my_app.my_app.dbG.Parametri.ParamQuery;
import com.my_app.my_app.dbG.Repository.Classsss.CategoryProductRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class NodeCategoryProductControllerGraphql {

    @Autowired
    private CategoryProductRep categoryProductRep;

    @QueryMapping
    public List<NodeCategoryProduct> getCategories(@Argument ParamQuery params) {
        return categoryProductRep.findByDynamicQuery(params);
    }
}
