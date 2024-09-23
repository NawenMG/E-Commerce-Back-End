package com.my_app.my_app.dbTS.Repository.Classss;

import org.influxdb.InfluxDB;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.threeten.bp.ZonedDateTime;

import com.my_app.my_app.dbTS.Models.AnalysisTraffic;
import com.my_app.my_app.dbTS.Parametri.ParamQuery;
import com.my_app.my_app.dbTS.Repository.Interfaceeee.AnalysisTrafficI;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Repository
public class AnalysisTrafficRep implements AnalysisTrafficI {

    @Autowired
    private InfluxDB influxDB;

    private String bucket = "AnalysisTraffic"; 

    // Query
    public List<AnalysisTraffic> query(ParamQuery paramQuery) {
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

        // Mappa i risultati in oggetti AnalysisTraffic
        return queryResult.getResults().stream()
            .flatMap(result -> result.getSeries().stream())
            .flatMap(series -> series.getValues().stream())
            .map(value -> {
                AnalysisTraffic analysisTraffic = new AnalysisTraffic();
                analysisTraffic.setUrl((String) value.get(0)); 
                analysisTraffic.setNumeroVisite((Integer) value.get(1)); 
                analysisTraffic.setNumeroVisiteUniche((Integer) value.get(2)); 
                analysisTraffic.setDurataMediaVisite((Double) value.get(3)); 
                analysisTraffic.setTimeStamp(ZonedDateTime.parse(value.get(4).toString())); 
                return analysisTraffic;
            }).collect(Collectors.toList());
    }

    // Insert
    public void insertTraffic(AnalysisTraffic analysisTraffic) {
        Point point = Point.measurement("AnalysisTraffic")
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .tag("Url", analysisTraffic.getUrl())
                .addField("NumeroVisite", analysisTraffic.getNumeroVisite())
                .addField("NumeroVisiteUniche", analysisTraffic.getNumeroVisiteUniche())
                .addField("DurataMediaVisite", analysisTraffic.getDurataMediaVisite())
                .build();

        influxDB.write(bucket, "autogen", point);
    }

    // Update non viene supportato direttamente, per modificare dei dati sovrascrivili con dati aventi lo stesso timestamp

    // Delete
    public void deleteData(String measurement, String url, long startTime, long endTime) {
        String query = String.format("DELETE FROM %s WHERE \"Url\"='%s' AND time >= %dms AND time <= %dms", 
                                      measurement, url, startTime, endTime);
        influxDB.query(new Query(query, bucket));
    }
}
