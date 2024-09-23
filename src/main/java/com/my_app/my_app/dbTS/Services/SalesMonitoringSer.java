package com.my_app.my_app.dbTS.Services;

import com.my_app.my_app.dbTS.Models.SalesMonitoring;
import com.my_app.my_app.dbTS.Parametri.ParamQuery;
import com.my_app.my_app.dbTS.Repository.Classss.SalesMonitoringRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesMonitoringSer {

    @Autowired
    private SalesMonitoringRep salesMonitoringRep;

    public List<SalesMonitoring> query(ParamQuery paramQuery) {
        return salesMonitoringRep.query(paramQuery);
    }

    public void insertSales(SalesMonitoring salesMonitoring) {
        salesMonitoringRep.insertSales(salesMonitoring);
    }

    public void deleteData(String measurement, String product, long startTime, long endTime) {
        salesMonitoringRep.deleteData(measurement, product, startTime, endTime);
    }
}
