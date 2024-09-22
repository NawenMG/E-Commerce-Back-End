package com.my_app.my_app.dbDoc.Parametri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.my_app.my_app.dbDoc.Collections.SchedaProdotto;

import java.util.List;
import java.util.Optional;

@Component
public class ParamQuerySchedaProdotto {
    
    @Autowired
    private MongoTemplate mongoTemplate;

    // Variabili di istanza
    private Optional<String> condizioneWhere = Optional.empty(); // Condizione di ricerca
    private Optional<String> valoriWhere = Optional.empty(); // Valore della condizione
    private Optional<String> boleani = Optional.empty(); // Condizioni booleane
    private Optional<String> like = Optional.empty(); // Condizioni LIKE
    private Optional<String> in = Optional.empty(); // Condizioni IN
    private Optional<String[]> between = Optional.empty(); // Condizioni BETWEEN
    private int limit = 40; // Limite di risultati
    private int offset = 0; // Offset per i risultati

    // Metodo per eseguire la query
    public List<SchedaProdotto> executeQuery(SchedaProdotto schedaProdotto) {
        Query query = new Query();

        // Aggiungi condizione WHERE se presente
        condizioneWhere.ifPresent(cond -> {
            query.addCriteria(Criteria.where(cond).is(valoriWhere.orElse(null)));
        });

        // Aggiungi condizioni booleane
        boleani.ifPresent(boolCondition -> {
            query.addCriteria(Criteria.where(boolCondition).is(true));
        });

        // Aggiungi LIKE se presente
        like.ifPresent(likeValue -> {
            query.addCriteria(Criteria.where("nome").regex(".*" + likeValue + ".*")); // Modificato per il campo nome
        });

        // Aggiungi IN se presente
        in.ifPresent(inValues -> {
            String[] values = inValues.split(",");
            query.addCriteria(Criteria.where("nome").in((Object[]) values)); // Modificato per il campo nome
        });

        // Aggiungi BETWEEN se presente
        between.ifPresent(betweenValues -> {
            if (betweenValues.length == 2) {
                query.addCriteria(Criteria.where("prezzo").gte(betweenValues[0]).lte(betweenValues[1])); // Modificato per il campo prezzo
            }
        });

        // Aggiungi LIMIT e OFFSET se specificato
        if (limit > 0) {
            query.limit(limit);
        }
        if (offset > 0) {
            query.skip(offset);
        }

        // Esegui la query e restituisci i risultati
        return mongoTemplate.find(query, SchedaProdotto.class);
    }

}
