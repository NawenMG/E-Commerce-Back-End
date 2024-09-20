package com.my_app.my_app.dbrel.parametri;

import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class ParmQueryOrders {
    private boolean distinct = false;
    private Optional<String> condizioneWhere = Optional.empty();
    private Optional<String> valoriWhere = Optional.empty();
    private Optional<String> boleani = Optional.empty();
    private boolean orderBy = false;
    private Integer top = null; // Utilizzare Integer per supportare il valore null
    private boolean min = false;
    private boolean max = false;
    private boolean count = false;
    private boolean avg = false;
    private boolean sum = false;
    private boolean all = false; 
    private Optional<String> like = Optional.empty();
    private Optional<String> in = Optional.empty();
    private Optional<String[]> between = Optional.empty();
    private Optional<String> having = Optional.empty();
    private int limit = 40;
    private int offset = limit;

    // Costruttore di default
    public ParmQueryOrders() {
        // I valori di default sono già stati impostati
    }

    // Getters e Setters
    public boolean isAll() {
        return all;
    }

    public void setAll(boolean all) {
        this.all = all;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public Optional<String> getCondizioneWhere() {
        return condizioneWhere;
    }

    public void setCondizioneWhere(Optional<String> condizioneWhere) {
        this.condizioneWhere = condizioneWhere;
    }

    public Optional<String> getValoriWhere() {
        return valoriWhere;
    }

    public void setValoriWhere(Optional<String> valoriWhere) {
        this.valoriWhere = valoriWhere;
    }

    public Optional<String> getBoleani() {
        return boleani;
    }

    public void setBoleani(Optional<String> boleani) {
        this.boleani = boleani;
    }

    public boolean isOrderBy() {
        return orderBy;
    }

    public void setOrderBy(boolean orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
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

    public boolean isCount() {
        return count;
    }

    public void setCount(boolean count) {
        this.count = count;
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

    public Optional<String> getLike() {
        return like;
    }

    public void setLike(Optional<String> like) {
        this.like = like;
    }

    public Optional<String> getIn() {
        return in;
    }

    public void setIn(Optional<String> in) {
        this.in = in;
    }

    public Optional<String[]> getBetween() {
        return between;
    }

    public void setBetween(Optional<String[]> between) {
        this.between = between;
    }

    public Optional<String> getHaving() {
        return having;
    }

    public void setHaving(Optional<String> having) {
        this.having = having;
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
