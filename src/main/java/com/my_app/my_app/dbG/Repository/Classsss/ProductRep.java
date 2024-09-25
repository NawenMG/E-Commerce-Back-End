package com.my_app.my_app.dbG.Repository.Classsss;

import com.my_app.my_app.dbG.Parametri.ParamQuery;
import com.my_app.my_app.dbG.Repository.Interfacceeeee.ProductI;
import com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione.NodeProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRep implements ProductI {

    @Autowired
    private Neo4jTemplate neo4jTemplate;

    @Autowired
    private Neo4jClient neo4jClient;

    // Metodo per cercare i prodotti in base a query dinamiche
    public List<NodeProduct> findByDynamicQuery(ParamQuery paramQuery) {
        StringBuilder cypherQuery = new StringBuilder("MATCH (p:NodeProduct)");

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
        String returnClause = paramQuery.getReturnFields().orElse("p");
        cypherQuery.append(" RETURN ").append(returnClause);

        // Esecuzione della query e mappatura dei risultati
        return neo4jTemplate.findAll(cypherQuery.toString(), NodeProduct.class);
    }

    // Metodo per inserire un nuovo nodo prodotto
    public void insertNodeProduct(NodeProduct product) {
         neo4jTemplate.save(product);
    }

    // Metodo per aggiornare un nodo prodotto esistente
    public void updateNodeProduct(NodeProduct product) {
         neo4jTemplate.save(product); 
    }

    // Metodo per eliminare un nodo prodotto
    public void deleteNodeProduct(String productId) {
        String cypherQuery = "MATCH (p:NodeProduct {productId: $productId}) DETACH DELETE p";
        neo4jClient.query(cypherQuery)
                    .bind(productId)
                    .to("productId")
                    .run();
    }
}
