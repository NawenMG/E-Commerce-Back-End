package com.my_app.my_app.dbTS.Repository.Classss;

import org.influxdb.*;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.threeten.bp.ZonedDateTime;

import com.my_app.my_app.dbTS.Models.SalesMonitoring;
import com.my_app.my_app.dbTS.Parametri.ParamQuery;
import com.my_app.my_app.dbTS.Repository.Interfaceeee.SalesMonitoringI;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Repository
public class SalesMonitoringRep implements SalesMonitoringI {

    @Autowired
    private InfluxDB influxDB;

    private String bucket = "SalesMonitoring";

    // Query
    public List<SalesMonitoring> query(ParamQuery paramQuery) {
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
        
        // Mappa i risultati in oggetti SalesMonitoring
        return queryResult.getResults().stream()
            .flatMap(result -> result.getSeries().stream())
            .flatMap(series -> series.getValues().stream())
            .map(value -> {
                SalesMonitoring salesMonitoring = new SalesMonitoring();
                salesMonitoring.setProduct((String) value.get(0)); 
                salesMonitoring.setCategory((String) value.get(1)); 
                salesMonitoring.setVenditore((String) value.get(2)); 
                salesMonitoring.setNumeroOrdini((Integer) value.get(3)); 
                salesMonitoring.setNumeroUnitàVendute((Integer) value.get(4)); 
                salesMonitoring.setRicavo((Double) value.get(5)); 
                salesMonitoring.setTimeStamp(ZonedDateTime.parse(value.get(6).toString())); 
                return salesMonitoring;
            }).collect(Collectors.toList());
    }

    // Insert
    public void insertSales(SalesMonitoring salesMonitoring) {
        Point point = Point.measurement("SalesMonitoring") 
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .tag("Product", salesMonitoring.getProduct())
                .tag("Category", salesMonitoring.getCategory())
                .tag("Venditore", salesMonitoring.getVenditore())
                .addField("NumeroOrdini", salesMonitoring.getNumeroOrdini())
                .addField("NumeroUnitàVendute", salesMonitoring.getNumeroUnitàVendute())
                .addField("Ricavo", salesMonitoring.getRicavo())
                .build();

        influxDB.write(bucket, "autogen", point);
    }

    // Update non viene supportato direttamente, per modificare dei dati sovrascrivili con dati aventi lo stesso timestamp
    
    // Delete
    public void deleteData(String measurement, String product, long startTime, long endTime) {
        String query = String.format("DELETE FROM %s WHERE \"Product\"='%s' AND time >= %dms AND time <= %dms", 
                                      measurement, product, startTime, endTime);
        influxDB.query(new Query(query, bucket));
    }
}
