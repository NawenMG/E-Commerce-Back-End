package com.my_app.my_app.dbG.Repository.Classsss;

import com.my_app.my_app.dbG.Parametri.ParamQuery;
import com.my_app.my_app.dbG.Repository.Interfacceeeee.UserI;
import com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione.NodeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRep implements UserI {

    @Autowired
    private Neo4jTemplate neo4jTemplate;

    @Autowired
    private Neo4jClient neo4jClient;

    // Metodo per cercare gli utenti in base a query dinamiche
    public List<NodeUser> findByDynamicQuery(ParamQuery paramQuery) {
        StringBuilder cypherQuery = new StringBuilder("MATCH (u:NodeUser)");

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
        String returnClause = paramQuery.getReturnFields().orElse("u");
        cypherQuery.append(" RETURN ").append(returnClause);

        // Esecuzione della query e mappatura dei risultati
        return neo4jTemplate.findAll(cypherQuery.toString(), NodeUser.class);
    }

    // Metodo per inserire un nuovo nodo utente
    public void insertNodeUser(NodeUser user) {
         neo4jTemplate.save(user);
    }

    // Metodo per aggiornare un nodo utente esistente
    public void updateNodeUser(NodeUser user) {
         neo4jTemplate.save(user); 
    }

    // Metodo per eliminare un nodo utente
    public void deleteNodeUser(String userId) {
        String cypherQuery = "MATCH (u:NodeUser {userId: $userId}) DETACH DELETE u";
        neo4jClient.query(cypherQuery)
                    .bind(userId)
                    .to("userId")
                    .run();
    }
}
