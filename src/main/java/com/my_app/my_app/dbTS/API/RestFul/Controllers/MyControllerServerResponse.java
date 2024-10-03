package com.my_app.my_app.dbTS.API.RestFul.Controllers;

import com.my_app.my_app.dbTS.Models.ServerResponse;
import com.my_app.my_app.dbTS.Parametri.ParamQuery;
import com.my_app.my_app.dbTS.Services.ServerResponseSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/server-response")
@PreAuthorize("hasRole('ADMIN')")
public class MyControllerServerResponse {

    @Autowired
    private ServerResponseSer serverResponseSer;

    @PostMapping("/query")
    public ResponseEntity<List<ServerResponse>> query(@RequestBody ParamQuery paramQuery) {
        List<ServerResponse> results = serverResponseSer.query(paramQuery);
        return ResponseEntity.ok(results);
    }

    @PostMapping("/insert")
    public void insert(@RequestBody ServerResponse serverResponse) {
        serverResponseSer.insertServerResponse(serverResponse);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam String measurement,
                                        @RequestParam String server,
                                        @RequestParam long startTime,
                                        @RequestParam long endTime) {
        serverResponseSer.deleteData(measurement, server, startTime, endTime);
    }
}
