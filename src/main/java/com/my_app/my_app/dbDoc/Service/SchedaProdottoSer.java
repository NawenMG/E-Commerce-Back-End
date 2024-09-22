package com.my_app.my_app.dbDoc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my_app.my_app.dbDoc.Collections.SchedaProdotto;
import com.my_app.my_app.dbDoc.Repository.Classss.SchedaProdottoRep;

import java.util.List;

@Service
public class SchedaProdottoSer {

    @Autowired
    private SchedaProdottoRep schedaProdottoRep; // Inietta il repository

    // Metodo per eseguire la query
    public List<SchedaProdotto> query(SchedaProdotto schedaProdotto) {
        return schedaProdottoRep.query(schedaProdotto);
    }

    // Metodo per inserire una nuova scheda prodotto
    public void insert(SchedaProdotto schedaProdotto) {
        schedaProdottoRep.CustomInsert(schedaProdotto);
    }

    // Metodo per aggiornare una scheda prodotto esistente
    public void update(SchedaProdotto schedaProdotto) {
        schedaProdottoRep.update(schedaProdotto);
    }

    // Metodo per eliminare una scheda prodotto per ID
    public void delete(int idSchedaProdotto) {
        schedaProdottoRep.delete(idSchedaProdotto);
    }
}
