package com.my_app.my_app.dbG.Repository.Classsss;

import com.my_app.my_app.dbG.Parametri.ParamQuery;
import com.my_app.my_app.dbG.Repository.Interfacceeeee.UserLocationI;
import com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione.NodeUserLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserLocationRep implements UserLocationI {

    @Autowired
    private Neo4jTemplate neo4jTemplate;

    @Autowired
    private Neo4jClient neo4jClient;

    // Metodo per cercare le localizzazioni utente in base a query dinamiche
    public List<NodeUserLocation> findByDynamicQuery(ParamQuery paramQuery) {
        StringBuilder cypherQuery = new StringBuilder("MATCH (l:NodeUserLocation)");

        // Aggiungere il pattern opzionale
        paramQuery.getPattern().ifPresent(pattern -> cypherQuery.append(" ").append(pattern));

        // Condizioni WHERE opzionali
        paramQuery.getWhereCondition().ifPresent(where -> cypherQuery.append(" WHERE ").append(where));

        // Ordina se necessario
        if (paramQuery.isOrderBy() && paramQuery.getOrderByField().isPresent()) {
            cypherQuery.append(" ORDER BY ").append(paramQuery.getOrderByField().get());
        }

        // Limite di risultati
        if (paramQuery.getLimit() != null) {
            cypherQuery.append(" LIMIT ").append(paramQuery.getLimit());
        }

        // Skip (offset) se presente
        if (paramQuery.getSkip() != null) {
            cypherQuery.append(" SKIP ").append(paramQuery.getSkip());
        }

        // Clausola RETURN
        String returnClause = paramQuery.getReturnFields().orElse("l");
        cypherQuery.append(" RETURN ").append(returnClause);

        // Esecuzione della query e mappatura dei risultati
        return neo4jTemplate.findAll(cypherQuery.toString(), NodeUserLocation.class);
    }

    // Metodo per inserire un nuovo nodo di localizzazione utente
    public void insertNodeUserLocation(NodeUserLocation location) {
         neo4jTemplate.save(location);
    }

    // Metodo per aggiornare un nodo di localizzazione utente esistente
    public void updateNodeUserLocation(NodeUserLocation location) {
         neo4jTemplate.save(location); 
    }

    // Metodo per eliminare un nodo di localizzazione utente
    public void deleteNodeUserLocation(String locationId) {
        String cypherQuery = "MATCH (l:NodeUserLocation {locationId: $locationId}) DETACH DELETE l";
        neo4jClient.query(cypherQuery)
                    .bind(locationId)
                    .to("locationId")
                    .run();
    }
}
