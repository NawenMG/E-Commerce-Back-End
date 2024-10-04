package com.my_app.my_app.dbTS.API.GraphQl.Controllers;

import com.my_app.my_app.dbTS.Models.AnalysisTraffic;
import com.my_app.my_app.dbTS.Parametri.ParamQuery;
import com.my_app.my_app.dbTS.Repository.Classss.AnalysisTrafficRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AnalysisTrafficControllerGraphql {

    @Autowired
    private AnalysisTrafficRep analysisTrafficRep;

    @QueryMapping
    public List<AnalysisTraffic> getTrafficAnalysis(@Argument ParamQuery params) {
        
        return analysisTrafficRep.query(params);
    }
}
