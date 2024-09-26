package com.my_app.my_app.dbTS.Controllers;

import com.my_app.my_app.dbTS.Models.AnalysisUser;
import com.my_app.my_app.dbTS.Parametri.ParamQuery;
import com.my_app.my_app.dbTS.Services.AnalysisUserSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ts/analysis-user")
@PreAuthorize("hasRole('ADMIN')")
public class MyControllerAnalysisUser {

    @Autowired
    private AnalysisUserSer analysisUserSer;

    @PostMapping("/query")
    public ResponseEntity<List<AnalysisUser>> query(@RequestBody ParamQuery paramQuery) {
        List<AnalysisUser> results = analysisUserSer.query(paramQuery);
        return ResponseEntity.ok(results);
    }

    @PostMapping("/insert")
    public void insert(@RequestBody AnalysisUser analysisUser) {
        analysisUserSer.insertUser(analysisUser);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam String measurement,
                                        @RequestParam String user,
                                        @RequestParam long startTime,
                                        @RequestParam long endTime) {
        analysisUserSer.deleteData(measurement, user, startTime, endTime);
    }
}
