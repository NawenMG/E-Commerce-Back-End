package com.my_app.my_app.dbCol.Repository.Classsss;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations; //Per effetturare le operazioni con cassandra
import org.springframework.stereotype.Repository;
import com.my_app.my_app.dbCol.Models.ArchiviazioneOrdini;
import com.my_app.my_app.dbCol.Parametri.ParamQuery;
import com.my_app.my_app.dbCol.Repository.Interfaceeee.ArchiviazioneOrdiniI;

@Repository
public class ArchiviazioneOrdiniRep implements ArchiviazioneOrdiniI {

    @Autowired
    private CassandraOperations cassandraTemplate;

    // Query
    public List<ArchiviazioneOrdini> query(ParamQuery paramQuery) {
        StringBuilder cql = new StringBuilder("SELECT ");

        if (paramQuery.isDistinct()) {
            cql.append("DISTINCT ");
        }

        cql.append("* FROM ArchiviazioneOrdini ");

        if (paramQuery.getCondizioneWhere().isPresent()) {
            cql.append("WHERE ").append(paramQuery.getCondizioneWhere().get()).append(" ");
        }

        if (paramQuery.isOrderBy()) {
            cql.append("ORDER BY ").append(paramQuery.getBoleani().orElse("ASC")).append(" ");
        }

        if (paramQuery.getLimit() > 0) {
            cql.append("LIMIT ").append(paramQuery.getLimit()).append(" ");
        }

        return cassandraTemplate.select(cql.toString(), ArchiviazioneOrdini.class);
    }

    // Insert
    public void insertOrdine(ArchiviazioneOrdini ordine) {
        cassandraTemplate.insert(ordine);
    }

    // Update
    public void updateOrdine(ArchiviazioneOrdini ordine) {
        cassandraTemplate.update(ordine);
    }

    // Delete
    public void deleteOrdine(int id) {
        ArchiviazioneOrdini ordine = new ArchiviazioneOrdini();
        ordine.setId(id);
        cassandraTemplate.delete(ordine);
    }
    
    
    
}
