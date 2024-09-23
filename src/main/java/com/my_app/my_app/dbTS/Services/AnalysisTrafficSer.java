package com.my_app.my_app.dbTS.Services;

import com.my_app.my_app.dbTS.Models.AnalysisTraffic;
import com.my_app.my_app.dbTS.Parametri.ParamQuery;
import com.my_app.my_app.dbTS.Repository.Interfaceeee.AnalysisTrafficI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalysisTrafficSer {

    @Autowired
    private AnalysisTrafficI analysisTrafficRep;

    public List<AnalysisTraffic> query(ParamQuery paramQuery) {
        return analysisTrafficRep.query(paramQuery);
    }

    public void insertTraffic(AnalysisTraffic analysisTraffic) {
        analysisTrafficRep.insertTraffic(analysisTraffic);
    }

    public void deleteData(String measurement, String url, long startTime, long endTime) {
        analysisTrafficRep.deleteData(measurement, url, startTime, endTime);
    }
}
