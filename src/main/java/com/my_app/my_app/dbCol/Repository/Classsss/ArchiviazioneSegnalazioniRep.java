package com.my_app.my_app.dbCol.Repository.Classsss;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations; //Per effetturare le operazioni con cassandra
import org.springframework.stereotype.Repository;
import com.my_app.my_app.dbCol.Models.ArchiviazioneSegnalazioni;
import com.my_app.my_app.dbCol.Parametri.ParamQuery;
import com.my_app.my_app.dbCol.Repository.Interfaceeee.ArchiviazioneSegnalazioniI;

@Repository
public class ArchiviazioneSegnalazioniRep implements ArchiviazioneSegnalazioniI {

    @Autowired
    private CassandraOperations cassandraTemplate;

    // Query
    public List<ArchiviazioneSegnalazioni> query(ParamQuery paramQuery) {
        StringBuilder cql = new StringBuilder("SELECT ");

        if (paramQuery.isDistinct()) {
            cql.append("DISTINCT ");
        }

        cql.append("* FROM ArchiviazioneSegnalazioni ");

        if (paramQuery.getCondizioneWhere().isPresent()) {
            cql.append("WHERE ").append(paramQuery.getCondizioneWhere().get()).append(" ");
        }

        if (paramQuery.isOrderBy()) {
            cql.append("ORDER BY ").append(paramQuery.getBoleani().orElse("ASC")).append(" ");
        }

        if (paramQuery.getLimit() > 0) {
            cql.append("LIMIT ").append(paramQuery.getLimit()).append(" ");
        }

        return cassandraTemplate.select(cql.toString(), ArchiviazioneSegnalazioni.class);
    }


    // Insert
    public void insertOrdine(ArchiviazioneSegnalazioni segnalazioni) {
        cassandraTemplate.insert(segnalazioni);
    }

    // Update
    public void updateOrdine(ArchiviazioneSegnalazioni segnalazioni) {
        cassandraTemplate.update(segnalazioni);
    }

    // Delete
    public void deleteOrdine(int id) {
        ArchiviazioneSegnalazioni segnalazioni = new ArchiviazioneSegnalazioni();
        segnalazioni.setId(id);
        cassandraTemplate.delete(segnalazioni);
    }
    
    
    
}
