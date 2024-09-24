package com.my_app.my_app.dbKey.Repository.Classss;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.my_app.my_app.dbKey.Models.Carrello;
import com.my_app.my_app.dbKey.Models.Settings;
import com.my_app.my_app.dbKey.Parametri.ParamQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SettingsRep {

    private final DynamoDBMapper dynamoDBMapper;

    @Autowired
    public SettingsRep(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public List<Settings> search(ParamQuery paramQuery) {
        Map<String, String> attributeNames = new HashMap<>();
        Map<String, AttributeValue> attributeValues = new HashMap<>();

        // Aggiungi condizioni per la chiave di partizione
        if (paramQuery.getPartitionKeyCondition().isPresent()) {
            attributeNames.put("#userID", "userID");
            attributeValues.put(":userID", new AttributeValue().withN(paramQuery.getPartitionKeyCondition().get()));
        }

        // Aggiungi condizioni per la chiave di ordinamento
        if (paramQuery.getSortKeyCondition().isPresent()) {
            attributeNames.put("#settingID", "settingID");
            attributeValues.put(":settingID", new AttributeValue().withN(paramQuery.getSortKeyCondition().get()));
        }

        // Costruisci l'espressione di query
        StringBuilder keyCondition = new StringBuilder("#userID = :userID");
        if (paramQuery.getSortKeyCondition().isPresent()) {
            keyCondition.append(" and #settingID = :settingID");
        }

        // Costruisci l'espressione di query
        DynamoDBQueryExpression<Settings> queryExpression = new DynamoDBQueryExpression<Settings>()
                .withKeyConditionExpression(keyCondition.toString())
                .withExpressionAttributeNames(attributeNames)
                .withExpressionAttributeValues(attributeValues)
                .withLimit(paramQuery.getLimit())
                .withExclusiveStartKey(paramQuery.getOffset() > 0 ? attributeValues : null);


        // Esegui la query
        return dynamoDBMapper.query(Settings.class, queryExpression);
    }


     // Salva o aggiorna un Carrello
    public void saveOrUpdate(Carrello carrello) {
        dynamoDBMapper.save(carrello);
    }

    // Trova un Carrello per userID e productID
    public Carrello findById(int userID, int productID) {
        return dynamoDBMapper.load(Carrello.class, userID, productID);
    }

    // Elimina un Carrello per userID e productID
    public void deleteById(int userID, int productID) {
        Carrello carrello = findById(userID, productID);
        if (carrello != null) {
            dynamoDBMapper.delete(carrello);
        }
    }
}
