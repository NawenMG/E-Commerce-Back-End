package com.my_app.my_app.dbTS.Repository.Classss;

import org.influxdb.*;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.threeten.bp.ZonedDateTime;

import com.my_app.my_app.dbTS.Models.ServerResponse;
import com.my_app.my_app.dbTS.Parametri.ParamQuery;
import com.my_app.my_app.dbTS.Repository.Interfaceeee.ServerResponseI;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Repository
public class ServerResponseRep implements ServerResponseI {

    @Autowired
    private InfluxDB influxDB;

    private String bucket = "ServerResponse"; 

    // Query
    public List<ServerResponse> query(ParamQuery paramQuery) {
        StringBuilder queryBuilder = new StringBuilder("from(bucket: \"" + bucket + "\")\n");

        if (paramQuery.getTimeRangeStart().isPresent() && paramQuery.getTimeRangeEnd().isPresent()) {
            queryBuilder.append("|> range(start: ")
                    .append(paramQuery.getTimeRangeStart().get())
                    .append(", stop: ")
                    .append(paramQuery.getTimeRangeEnd().get())
                    .append(")\n");
        }

        if (paramQuery.getWhereClause().isPresent()) {
            queryBuilder.append("|> filter(fn: (r) => ")
                    .append(paramQuery.getWhereClause().get())
                    .append(")\n");
        }

        // Esegui la query
        String query = queryBuilder.toString();
        QueryResult queryResult = influxDB.query(new Query(query, bucket));
        
        // Mappa i risultati in oggetti ServerResponse
        return queryResult.getResults().stream()
            .flatMap(result -> result.getSeries().stream())
            .flatMap(series -> series.getValues().stream())
            .map(value -> {
                ServerResponse serverResponse = new ServerResponse();
                serverResponse.setServer((String) value.get(0)); 
                serverResponse.setEndpoint((String) value.get(1)); 
                serverResponse.setResponseTimeAverage((Double) value.get(2)); 
                serverResponse.setRequestNumbers((Integer) value.get(3)); 
                serverResponse.setErrorsNumbers((Integer) value.get(4));
                serverResponse.setTimeStamp(ZonedDateTime.parse(value.get(5).toString())); 
                return serverResponse;
            }).collect(Collectors.toList());
    }

    // Insert
    public void insertServerResponse(ServerResponse serverResponse) {
        Point point = Point.measurement("ServerResponse") 
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS) 
                .tag("Server", serverResponse.getServer())
                .tag("Endpoint", serverResponse.getEndpoint())
                .addField("ResponseTimeAverage", serverResponse.getResponseTimeAverage())
                .addField("RequestNumbers", serverResponse.getRequestNumbers())
                .addField("ErrorsNumbers", serverResponse.getErrorsNumbers())
                .build();

        influxDB.write(bucket, "autogen", point);
    }

    // Update non viene supportato direttamente, per modificare dei dati sovrascrivili con dati aventi lo stesso timestamp

    // Delete
    public void deleteData(String measurement, String server, long startTime, long endTime) {
        String query = String.format("DELETE FROM %s WHERE \"Server\"='%s' AND time >= %dms AND time <= %dms", 
                                      measurement, server, startTime, endTime);
        influxDB.query(new Query(query, bucket));
    }
}
