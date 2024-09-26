package com.my_app.my_app.dbTS.Controllers;

import com.my_app.my_app.dbTS.Models.SalesMonitoring;
import com.my_app.my_app.dbTS.Parametri.ParamQuery;
import com.my_app.my_app.dbTS.Services.SalesMonitoringSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ts/sales-monitoring")
@PreAuthorize("hasRole('ADMIN')")
public class MyControllerSalesMonitoring {

    @Autowired
    private SalesMonitoringSer salesMonitoringSer;

    @PostMapping("/query")
    public ResponseEntity<List<SalesMonitoring>> query(@RequestBody ParamQuery paramQuery) {
        List<SalesMonitoring> results = salesMonitoringSer.query(paramQuery);
        return ResponseEntity.ok(results);
    }

    @PostMapping("/insert")
    public void insert(@RequestBody SalesMonitoring salesMonitoring) {
        salesMonitoringSer.insertSales(salesMonitoring);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam String measurement,
                                        @RequestParam String product,
                                        @RequestParam long startTime,
                                        @RequestParam long endTime) {
        salesMonitoringSer.deleteData(measurement, product, startTime, endTime);
    }
}
