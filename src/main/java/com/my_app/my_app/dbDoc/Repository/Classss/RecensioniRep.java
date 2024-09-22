package com.my_app.my_app.dbDoc.Repository.Classss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.my_app.my_app.dbDoc.Collections.Recensioni;
import com.my_app.my_app.dbDoc.Parametri.ParamQueryRecensioni;
import com.my_app.my_app.dbDoc.Repository.Interfaceee.RecensioniI;

import java.util.List;

@Repository
public class RecensioniRep implements RecensioniI {

    @Autowired
    private MongoTemplate mongoTemplate; // Inietta MongoTemplate

    @Autowired
    private ParamQueryRecensioni paramQueryRecensioni; // Inietta ParamQueryRecensioni

    // Metodo per eseguire la query
    public List<Recensioni> query(Recensioni recensioni) {
        return paramQueryRecensioni.executeQuery(recensioni); // Esegui la query
    }

    // Insert
    public void CustomInsert(Recensioni recensioni) {
        mongoTemplate.insert(recensioni); // Utilizza insert per MongoDB
    }

    // Update
    public void update(Recensioni recensioni) {
        Query query = new Query(Criteria.where("idReview").is(recensioni.getIdReview())); // Assicurati di avere un campo ID
        Update update = new Update();
        // Aggiorna i campi che desideri
        update.set("titolo", recensioni.getTitolo());
        update.set("rate", recensioni.getRate());
        update.set("body", recensioni.getBody());
        update.set("verificadellAcquisto", recensioni.isVerificadellAcquisto());
        update.set("like", recensioni.isLike());
        update.set("dislike", recensioni.isDislike());
        update.set("tags", recensioni.getTags()); // Aggiorna i tags
        update.set("campiAggiuntivi", recensioni.getCampiAggiuntivi()); // Aggiungi i campi aggiuntivi
        mongoTemplate.updateFirst(query, update, Recensioni.class);
    }

    // Metodo per eliminare una recensione per ID
    public void delete(int idReview) {
        Query query = new Query(Criteria.where("idReview").is(idReview)); // Cambia "idReview" se necessario
        mongoTemplate.remove(query, Recensioni.class);
    }
}
