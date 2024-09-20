package com.my_app.my_app.dbrel.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.my_app.my_app.dbrel.model.Returns;
import com.my_app.my_app.dbrel.parametri.ParmQueryReturns;
import com.my_app.my_app.dbrel.servicee.ReturnsSer;

@RestController
@RequestMapping("/returns")
public class MyControllerReturns {
    
    @Autowired
    private ReturnsSer returnsSer;

    // Query
    @PostMapping("/query")
    @ResponseBody
    public List<Returns> query(@RequestBody ParmQueryReturns parmQuery) {
        return returnsSer.queryService(parmQuery);
    }

    // Inserisci un nuovo reso
    @PostMapping("/insert")
    @ResponseBody
    public String createReturn(@RequestBody Returns returns) {
        returnsSer.insertReturnService(returns);
        return "Return created successfully!";
    }

    // Aggiorna un reso esistente
    @PutMapping("/update/{returnsID}")
    @ResponseBody
    public String updateReturn(@PathVariable int returnsID, @RequestBody Returns returns) {
        returns.setReturnsID(returnsID);
        returnsSer.updateReturnService(returns);
        return "Return updated successfully!";
    }

    // Elimina un reso
    @DeleteMapping("/delete/{returnsID}")
    @ResponseBody
    public String deleteReturn(@PathVariable int returnsID) {
        returnsSer.deleteReturnService(returnsID);
        return "Return deleted successfully!";
    }

    // Faker per inserire dei dati
    @PostMapping("/faker/{numberOfReturns}")
    @ResponseBody
    public String generateReturns(@PathVariable int numberOfReturns) {
        returnsSer.saveAllService(numberOfReturns);
        return "Returns generated and saved successfully!";
    }
}
