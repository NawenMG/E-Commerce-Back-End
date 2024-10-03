package com.my_app.my_app.dbrel.JDBC.API.RestFul.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.my_app.my_app.dbrel.JDBC.model.Returns;
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryReturns;
import com.my_app.my_app.dbrel.JDBC.servicee.ReturnsSer;

@RestController
@RequestMapping("jdbc/returns")
public class MyControllerReturns {
    
    @Autowired
    private ReturnsSer returnsSer;

    // Query
    @PostMapping("jdbc/query")
    @ResponseBody
    public List<Returns> query(@RequestBody ParmQueryReturns parmQuery) {
        return returnsSer.queryService(parmQuery);
    }

    // Inserisci un nuovo reso
    @PostMapping("jdbc/insert")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseBody
    public String createReturn(@RequestBody Returns returns) {
        returnsSer.insertReturnService(returns);
        return "Return created successfully!";
    }

    // Aggiorna un reso esistente
    @PutMapping("jdbc/update/{returnsID}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseBody
    public String updateReturn(@PathVariable int returnsID, @RequestBody Returns returns) {
        returns.setReturnsID(returnsID);
        returnsSer.updateReturnService(returns);
        return "Return updated successfully!";
    }

    // Elimina un reso
    @DeleteMapping("jdbc/delete/{returnsID}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseBody
    public String deleteReturn(@PathVariable int returnsID) {
        returnsSer.deleteReturnService(returnsID);
        return "Return deleted successfully!";
    }

    // Faker per inserire dei dati
    @PostMapping("jdbc/faker/{numberOfReturns}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseBody
    public String generateReturns(@PathVariable int numberOfReturns) {
        returnsSer.saveAllService(numberOfReturns);
        return "Returns generated and saved successfully!";
    }
}
