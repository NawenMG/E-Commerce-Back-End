package com.my_app.my_app.dbG.Parametri;

import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class ParamQuery {
    private boolean distinct = false;
    private Optional<String> whereCondition = Optional.empty();  // Condizioni WHERE
    private Optional<String> relationshipType = Optional.empty();  // Tipo di relazione
    private Optional<String> nodeLabel = Optional.empty();  // Label del nodo
    private boolean orderBy = false;
    private Optional<String> orderByField = Optional.empty();  // Campo per ORDER BY
    private Integer limit = 40;
    private Integer skip = 0; // equivalente di OFFSET per Neo4j

    private Optional<String> pattern = Optional.empty(); // Pattern di matching del grafo
    private Optional<String> returnFields = Optional.empty(); // Specificare i campi da restituire

    private boolean count = false;
    private boolean min = false;
    private boolean max = false;
    private boolean avg = false;
    private boolean sum = false;

    public ParamQuery() {
    }


    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public Optional<String> getWhereCondition() {
        return whereCondition;
    }

    public void setWhereCondition(Optional<String> whereCondition) {
        this.whereCondition = whereCondition;
    }

    public Optional<String> getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(Optional<String> relationshipType) {
        this.relationshipType = relationshipType;
    }

    public Optional<String> getNodeLabel() {
        return nodeLabel;
    }

    public void setNodeLabel(Optional<String> nodeLabel) {
        this.nodeLabel = nodeLabel;
    }

    public boolean isOrderBy() {
        return orderBy;
    }

    public void setOrderBy(boolean orderBy) {
        this.orderBy = orderBy;
    }

    public Optional<String> getOrderByField() {
        return orderByField;
    }

    public void setOrderByField(Optional<String> orderByField) {
        this.orderByField = orderByField;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getSkip() {
        return skip;
    }

    public void setSkip(Integer skip) {
        this.skip = skip;
    }

    public Optional<String> getPattern() {
        return pattern;
    }

    public void setPattern(Optional<String> pattern) {
        this.pattern = pattern;
    }

    public Optional<String> getReturnFields() {
        return returnFields;
    }

    public void setReturnFields(Optional<String> returnFields) {
        this.returnFields = returnFields;
    }

    public boolean isCount() {
        return count;
    }

    public void setCount(boolean count) {
        this.count = count;
    }

    public boolean isMin() {
        return min;
    }

    public void setMin(boolean min) {
        this.min = min;
    }

    public boolean isMax() {
        return max;
    }

    public void setMax(boolean max) {
        this.max = max;
    }

    public boolean isAvg() {
        return avg;
    }

    public void setAvg(boolean avg) {
        this.avg = avg;
    }

    public boolean isSum() {
        return sum;
    }

    public void setSum(boolean sum) {
        this.sum = sum;
    }
}