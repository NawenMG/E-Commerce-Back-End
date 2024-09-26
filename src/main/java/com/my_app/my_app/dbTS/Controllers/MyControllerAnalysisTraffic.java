package com.my_app.my_app.dbTS.Controllers;

import com.my_app.my_app.dbTS.Models.AnalysisTraffic;
import com.my_app.my_app.dbTS.Parametri.ParamQuery;
import com.my_app.my_app.dbTS.Services.AnalysisTrafficSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ts/analysis-traffic")
@PreAuthorize("hasRole('ADMIN')")
public class MyControllerAnalysisTraffic {

    @Autowired
    private AnalysisTrafficSer analysisTrafficSer;

    @PostMapping("/query")
    public ResponseEntity<List<AnalysisTraffic>> query(@RequestBody ParamQuery paramQuery) {
        List<AnalysisTraffic> results = analysisTrafficSer.query(paramQuery);
        return ResponseEntity.ok(results);
    }

    @PostMapping("/insert")
    public void insert(@RequestBody AnalysisTraffic analysisTraffic) {
        analysisTrafficSer.insertTraffic(analysisTraffic);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam String measurement,
                                        @RequestParam String url,
                                        @RequestParam long startTime,
                                        @RequestParam long endTime) {
        analysisTrafficSer.deleteData(measurement, url, startTime, endTime);
    }
}
