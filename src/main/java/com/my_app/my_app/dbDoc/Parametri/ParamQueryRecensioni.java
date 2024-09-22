package com.my_app.my_app.dbDoc.Parametri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.my_app.my_app.dbDoc.Collections.Recensioni;

import java.util.List;
import java.util.Optional;

@Component
public class ParamQueryRecensioni {

    @Autowired
    private MongoTemplate mongoTemplate;

    // Variabili di istanza
    private Optional<String> condizioneWhere = Optional.empty(); // Condizione di ricerca
    private Optional<String> valoriWhere = Optional.empty(); // Valore della condizione
    private Optional<Integer> rate = Optional.empty(); // Condizione sul rating
    private Optional<Boolean> verificadellAcquisto = Optional.empty(); // Condizione sull'acquisto verificato
    private Optional<String> like = Optional.empty(); // Condizioni LIKE per il titolo
    private Optional<String> inTags = Optional.empty(); // Condizioni IN per i tag
    private int limit = 40; // Limite di risultati
    private int offset = 0; // Offset per i risultati

    // Metodo per eseguire la query
    public List<Recensioni> executeQuery(Recensioni recensioni) {
        Query query = new Query();

        // Aggiungi condizione WHERE se presente
        condizioneWhere.ifPresent(cond -> {
            query.addCriteria(Criteria.where(cond).is(valoriWhere.orElse(null)));
        });

        // Aggiungi condizioni sul rating se presente
        rate.ifPresent(rateValue -> {
            query.addCriteria(Criteria.where("rate").is(rateValue));
        });

        // Aggiungi condizione sull'acquisto verificato se presente
        verificadellAcquisto.ifPresent(isVerified -> {
            query.addCriteria(Criteria.where("verificadellAcquisto").is(isVerified));
        });

        // Aggiungi LIKE se presente per il titolo
        like.ifPresent(likeValue -> {
            query.addCriteria(Criteria.where("titolo").regex(".*" + likeValue + ".*"));
        });

        // Aggiungi IN se presente per i tag
        inTags.ifPresent(tagsValue -> {
            String[] tags = tagsValue.split(",");
            query.addCriteria(Criteria.where("tags").in((Object[]) tags));
        });

        // Aggiungi LIMIT e OFFSET se specificato
        if (limit > 0) {
            query.limit(limit);
        }
        if (offset > 0) {
            query.skip(offset);
        }

        // Esegui la query e restituisci i risultati
        return mongoTemplate.find(query, Recensioni.class);
    }

}
