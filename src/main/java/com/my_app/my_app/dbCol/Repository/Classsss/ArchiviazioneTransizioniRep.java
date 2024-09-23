package com.my_app.my_app.dbCol.Repository.Classsss;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations; //Per effetturare le operazioni con cassandra
import org.springframework.stereotype.Repository;
import com.my_app.my_app.dbCol.Models.ArchiviazioneTransizioni;
import com.my_app.my_app.dbCol.Parametri.ParamQuery;
import com.my_app.my_app.dbCol.Repository.Interfaceeee.ArchiviazioneTransizioniI;

@Repository
public class ArchiviazioneTransizioniRep implements ArchiviazioneTransizioniI {

    @Autowired
    private CassandraOperations cassandraTemplate;

    // Query
    public List<ArchiviazioneTransizioni> query(ParamQuery paramQuery) {
        StringBuilder cql = new StringBuilder("SELECT ");

        if (paramQuery.isDistinct()) {
            cql.append("DISTINCT ");
        }

        cql.append("* FROM ArchiviazioneTransizioni ");

        if (paramQuery.getCondizioneWhere().isPresent()) {
            cql.append("WHERE ").append(paramQuery.getCondizioneWhere().get()).append(" ");
        }

        if (paramQuery.isOrderBy()) {
            cql.append("ORDER BY ").append(paramQuery.getBoleani().orElse("ASC")).append(" ");
        }

        if (paramQuery.getLimit() > 0) {
            cql.append("LIMIT ").append(paramQuery.getLimit()).append(" ");
        }

        return cassandraTemplate.select(cql.toString(), ArchiviazioneTransizioni.class);
    }


    // Insert
    public void insertOrdine(ArchiviazioneTransizioni transizioni) {
        cassandraTemplate.insert(transizioni);
    }

    // Update
    public void updateOrdine(ArchiviazioneTransizioni transizioni) {
        cassandraTemplate.update(transizioni);
    }

    // Delete
    public void deleteOrdine(int id) {
        ArchiviazioneTransizioni transizioni = new ArchiviazioneTransizioni();
        transizioni.setId(id);
        cassandraTemplate.delete(transizioni);
    }
    
    
    
}
