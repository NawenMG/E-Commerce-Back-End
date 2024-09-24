package com.my_app.my_app.dbKey.Parametri;

import java.util.Optional;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class ParamQuery {

    private Optional<String> partitionKeyCondition = Optional.empty(); //Chiave di partizione
    private Optional<String> sortKeyCondition = Optional.empty(); //Chiave sort
    private Optional<Map<String, String>> attributeValues = Optional.empty(); //Valore degli attributi
    private Optional<String> filterExpression = Optional.empty(); //Per applicare delle condizioni specifiche ai dati
    private Optional<String> projectionExpression = Optional.empty(); //Per selezionare solo certi tipi di attributi all'interno di ogni elemento 
    private int limit = 40;
    private int offset = 0;

    // Costruttore di default
    public ParamQuery() {
    }

    // Getters e Setters
    public Optional<String> getPartitionKeyCondition() {
        return partitionKeyCondition;
    }

    public void setPartitionKeyCondition(Optional<String> partitionKeyCondition) {
        this.partitionKeyCondition = partitionKeyCondition;
    }

    public Optional<String> getSortKeyCondition() {
        return sortKeyCondition;
    }

    public void setSortKeyCondition(Optional<String> sortKeyCondition) {
        this.sortKeyCondition = sortKeyCondition;
    }

    public Optional<Map<String, String>> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(Optional<Map<String, String>> attributeValues) {
        this.attributeValues = attributeValues;
    }

    public Optional<String> getFilterExpression() {
        return filterExpression;
    }

    public void setFilterExpression(Optional<String> filterExpression) {
        this.filterExpression = filterExpression;
    }

    public Optional<String> getProjectionExpression() {
        return projectionExpression;
    }

    public void setProjectionExpression(Optional<String> projectionExpression) {
        this.projectionExpression = projectionExpression;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

}
