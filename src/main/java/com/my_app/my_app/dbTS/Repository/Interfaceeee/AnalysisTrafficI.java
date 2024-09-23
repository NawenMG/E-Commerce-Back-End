package com.my_app.my_app.dbTS.Repository.Interfaceeee;

import com.my_app.my_app.dbTS.Models.AnalysisTraffic;
import com.my_app.my_app.dbTS.Parametri.ParamQuery;

import java.util.List;

public interface AnalysisTrafficI {

    List<AnalysisTraffic> query(ParamQuery paramQuery);

    void insertTraffic(AnalysisTraffic analysisTraffic);

    void deleteData(String measurement, String url, long startTime, long endTime);
}
