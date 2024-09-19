package com.my_app.my_app.dbrel.parametri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.my_app.my_app.dbrel.repository.ProductsRep;

@Service 
public class ParmQueryService {

    private final ProductsRep productsRep;

    public String processQuery(ParmQuery parmQuery) {
        String query = productsRep.query(parmQuery);
        return "Query costruita con successo: " + query; 
    }
}
