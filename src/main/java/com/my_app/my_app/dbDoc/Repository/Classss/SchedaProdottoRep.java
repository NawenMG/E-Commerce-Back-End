package com.my_app.my_app.dbDoc.Repository.Classss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.my_app.my_app.dbDoc.Collections.SchedaProdotto;
import com.my_app.my_app.dbDoc.Parametri.ParamQuerySchedaProdotto;
import com.my_app.my_app.dbDoc.Repository.Interfaceee.SchedaProdottoI;

import java.util.List;

@Repository
public class SchedaProdottoRep implements SchedaProdottoI {

    @Autowired
    private MongoTemplate mongoTemplate; // Inietta MongoTemplate

    @Autowired
    private ParamQuerySchedaProdotto paramQuerySchedaProdotto; // Inietta ParamQuerySchedaProdotto

    // Metodo per eseguire la query
    public List<SchedaProdotto> query(SchedaProdotto schedaProdotto) {
        return paramQuerySchedaProdotto.executeQuery(schedaProdotto);
    }

    // Insert
    public void CustomInsert(SchedaProdotto schedaProdotto) {
        mongoTemplate.insert(schedaProdotto); // Utilizza insert per MongoDB
    }

    // Update
    public void update(SchedaProdotto schedaProdotto) {
        Query query = new Query(Criteria.where("idSchedaProdotto").is(schedaProdotto.getIdSchedaProdotto())); // Assicurati di avere un campo ID
        Update update = new Update();
        // Aggiorna i campi che desideri
        update.set("nome", schedaProdotto.getNome());
        update.set("prezzo", schedaProdotto.getPrezzo());
        update.set("campiAggiuntivi", schedaProdotto.getCampiAggiuntivi()); // Aggiungi i campi aggiuntivi
        mongoTemplate.updateFirst(query, update, SchedaProdotto.class);
    }

    // Metodo per eliminare una scheda prodotto per ID
    public void delete(int idSchedaProdotto) {
        Query query = new Query(Criteria.where("idSchedaProdotto").is(idSchedaProdotto)); // Cambia "idSchedaProdotto" se necessario
        mongoTemplate.remove(query, SchedaProdotto.class);
    }
}
