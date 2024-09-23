package com.my_app.my_app.dbTS.Repository.Interfaceeee;

import com.my_app.my_app.dbTS.Models.SalesMonitoring;
import com.my_app.my_app.dbTS.Parametri.ParamQuery;

import java.util.List;

public interface SalesMonitoringI {

    List<SalesMonitoring> query(ParamQuery paramQuery);

    void insertSales(SalesMonitoring salesMonitoring);

    void deleteData(String measurement, String product, long startTime, long endTime);
}
