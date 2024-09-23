package com.my_app.my_app.dbTS.Repository.Interfaceeee;

import com.my_app.my_app.dbTS.Models.ServerResponse;
import com.my_app.my_app.dbTS.Parametri.ParamQuery;

import java.util.List;

public interface ServerResponseI {

    List<ServerResponse> query(ParamQuery paramQuery);

    void insertServerResponse(ServerResponse serverResponse);

    void deleteData(String measurement, String server, long startTime, long endTime);
}
