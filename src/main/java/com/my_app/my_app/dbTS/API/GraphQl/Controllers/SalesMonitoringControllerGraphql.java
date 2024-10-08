package com.my_app.my_app.dbTS.API.GraphQl.Controllers;

import com.my_app.my_app.dbTS.Models.SalesMonitoring;
import com.my_app.my_app.dbTS.Parametri.ParamQuery;
import com.my_app.my_app.dbTS.Repository.Classss.SalesMonitoringRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SalesMonitoringControllerGraphql {

    @Autowired
    private SalesMonitoringRep salesMonitoringRep;

    @QueryMapping
    @PreAuthorize("hasRole('ADMIN', 'CONTROLLER')")
    public List<SalesMonitoring> getSalesData(@Argument ParamQuery params) {
        
        return salesMonitoringRep.query(params);
    }
}
