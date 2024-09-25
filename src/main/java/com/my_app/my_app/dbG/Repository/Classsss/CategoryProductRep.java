package com.my_app.my_app.dbG.Repository.Classsss;

import com.my_app.my_app.dbG.Parametri.ParamQuery;
import com.my_app.my_app.dbG.Repository.Interfacceeeee.CategoryProductI;
import com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione.NodeCategoryProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryProductRep implements CategoryProductI {

    @Autowired
    private Neo4jTemplate neo4jTemplate;

    //Query
    public List<NodeCategoryProduct> findByDynamicQuery(ParamQuery paramQuery) {
        StringBuilder cypherQuery = new StringBuilder("MATCH (c:NodeCategoryProduct)");

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
        String returnClause = paramQuery.getReturnFields().orElse("c");
        cypherQuery.append(" RETURN ").append(returnClause);

        // Esecuzione della query e mappatura dei risultati
        return neo4jTemplate.findAll(cypherQuery.toString(), NodeCategoryProduct.class);
    }

    // Metodo per inserire un nuovo nodo categoria prodotto
    public void insertNodeCategoryProduct(NodeCategoryProduct categoryProduct) {
         neo4jTemplate.save(categoryProduct);
    }

    // Metodo per aggiornare un nodo categoria prodotto esistente
    public void updateNodeCategoryProduct(NodeCategoryProduct categoryProduct) {
         neo4jTemplate.save(categoryProduct);  
    }

    // Metodo per eliminare un nodo categoria prodotto
    @Autowired
    private Neo4jClient neo4jClient;

    public void deleteNodeCategoryProduct(String categoryId) {
        String cypherQuery = "MATCH (c:NodeCategoryProduct {categoryId: $categoryId}) DETACH DELETE c";
        neo4jClient.query(cypherQuery)
                    .bind(categoryId)
                    .to("categoryId")
                    .run();
    }
    
    
    
    
}
