package com.my_app.my_app.dbTS.Repository.Classss;

import org.influxdb.*;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.threeten.bp.ZonedDateTime;

import com.my_app.my_app.dbTS.Models.AnalysisUser;
import com.my_app.my_app.dbTS.Parametri.ParamQuery;
import com.my_app.my_app.dbTS.Repository.Interfaceeee.AnalysisUserI;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Repository
public class AnalysisUserRep implements AnalysisUserI {

    @Autowired
    private InfluxDB influxDB;

    private String bucket = "AnalysisUser"; 

    // Query
    public List<AnalysisUser> query(ParamQuery paramQuery) {
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
        
        // Mappa i risultati in oggetti AnalysisUser
        return queryResult.getResults().stream()
            .flatMap(result -> result.getSeries().stream())
            .flatMap(series -> series.getValues().stream())
            .map(value -> {
                AnalysisUser analysisUser = new AnalysisUser();
                analysisUser.setUser((String) value.get(0));
                analysisUser.setTypeDevice((String) value.get(1)); 
                analysisUser.setAction((String) value.get(2)); 
                analysisUser.setDuringAction((Long) value.get(3)); 
                analysisUser.setTimeStamp(ZonedDateTime.parse(value.get(4).toString())); 
                return analysisUser;
            }).collect(Collectors.toList());
    }



    // Insert
    public void insertUser(AnalysisUser analysisUser) {
        Point point = Point.measurement("AnalysisUser") 
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS) 
                .tag("User", analysisUser.getUser())
                .tag("TypeDevice", analysisUser.getTypeDevice())
                .addField("Action", analysisUser.getAction())
                .addField("DuringAction", analysisUser.getDuringAction())
                .build();

        influxDB.write(bucket, "autogen", point);
    }


    // Update non viene supportato direttamente, per modificare dei dati sovrascrivili con dati aventi lo stesso timestamp
    
    // Delete
    public void deleteData(String measurement, String user, long startTime, long endTime) {
        String query = String.format("DELETE FROM %s WHERE \"User\"='%s' AND time >= %dms AND time <= %dms", 
                                      measurement, user, startTime, endTime);
        influxDB.query(new Query(query, bucket));
    }
}
