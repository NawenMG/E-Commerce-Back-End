package com.my_app.my_app.dbDoc.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.my_app.my_app.dbDoc.Collections.SchedaProdotto;
import com.my_app.my_app.dbDoc.Service.SchedaProdottoSer;

import java.util.List;

@RestController
@RequestMapping("/api/doc/scheda-prodotto")
public class MyControllerSchedaProdotto {

    @Autowired
    private SchedaProdottoSer schedaProdottoSer; 

    @GetMapping("/query")
    public List<SchedaProdotto> query(SchedaProdotto schedaProdotto) {
        return schedaProdottoSer.query(schedaProdotto);
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('SELLER')")
    public void create(@RequestBody SchedaProdotto schedaProdotto) {
        schedaProdottoSer.insert(schedaProdotto); 
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('SELLER')")
    public void update(@RequestBody SchedaProdotto schedaProdotto) {
        schedaProdottoSer.update(schedaProdotto); 
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('SELLER')")
    public void delete(@PathVariable int id) {
        schedaProdottoSer.delete(id); 
    }
}
