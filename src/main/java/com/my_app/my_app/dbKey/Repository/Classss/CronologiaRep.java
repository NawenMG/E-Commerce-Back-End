package com.my_app.my_app.dbKey.Repository.Classss;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.my_app.my_app.dbKey.Models.Carrello;
import com.my_app.my_app.dbKey.Models.Cronologia;
import com.my_app.my_app.dbKey.Parametri.ParamQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CronologiaRep {

    @Autowired
    private  DynamoDBMapper dynamoDBMapper;


    public List<Cronologia> search(ParamQuery paramQuery) {
        Map<String, String> attributeNames = new HashMap<>();
        Map<String, AttributeValue> attributeValues = new HashMap<>();

        // Aggiungi condizioni per la chiave di partizione
        if (paramQuery.getPartitionKeyCondition().isPresent()) {
            attributeNames.put("#userID", "userID");
            attributeValues.put(":userID", new AttributeValue().withN(paramQuery.getPartitionKeyCondition().get()));
        }

        // Aggiungi condizioni per la chiave di ordinamento
        if (paramQuery.getSortKeyCondition().isPresent()) {
            attributeNames.put("#productID", "productID");
            attributeValues.put(":productID", new AttributeValue().withN(paramQuery.getSortKeyCondition().get()));
        }

        // Costruisci l'espressione di query
        StringBuilder keyCondition = new StringBuilder("#userID = :userID");
        if (paramQuery.getSortKeyCondition().isPresent()) {
            keyCondition.append(" and #productID = :productID");
        }

        // Costruisci l'espressione di query
        DynamoDBQueryExpression<Cronologia> queryExpression = new DynamoDBQueryExpression<Cronologia>()
                .withKeyConditionExpression(keyCondition.toString())
                .withExpressionAttributeNames(attributeNames)
                .withExpressionAttributeValues(attributeValues)
                .withLimit(paramQuery.getLimit())
                .withExclusiveStartKey(paramQuery.getOffset() > 0 ? attributeValues : null);

        // Esegui la query
        return dynamoDBMapper.query(Cronologia.class, queryExpression);
    }

     // Salva o aggiorna cronologia
    public void saveOrUpdate(Cronologia cronologia) {
        dynamoDBMapper.save(cronologia);
    }

    // Trova cronologia per userID e productID
    public Carrello findById(int userID, int productID) {
        return dynamoDBMapper.load(Carrello.class, userID, productID);
    }

    // Elimina cronologia per userID e productID
    public void deleteById(int userID, int productID) {
        Carrello carrello = findById(userID, productID);
        if (carrello != null) {
            dynamoDBMapper.delete(carrello);
        }
    }
}
