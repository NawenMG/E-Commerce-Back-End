package com.my_app.my_app.dbrel.JDBC.API.GraphQl.Controllers;

import com.my_app.my_app.dbrel.JDBC.model.Payments; 
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryPayments;
import com.my_app.my_app.dbrel.JDBC.repository.classs.PaymentsRep; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PaymentsControllerGraphql {

    @Autowired
    private PaymentsRep paymentsRep; 

    @QueryMapping
    @PreAuthorize("hasRole('USER')")
    public List<Payments> getPayments(@Argument ParmQueryPayments params) {
        return paymentsRep.query(params); 
    }
}
