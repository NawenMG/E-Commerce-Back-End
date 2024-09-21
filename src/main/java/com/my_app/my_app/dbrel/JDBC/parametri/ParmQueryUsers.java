package com.my_app.my_app.dbrel.JDBC.parametri;

import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class ParmQueryUsers {
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
    public ParmQueryUsers() {
        // I valori di default sono già stati impostati
    }

    // Getters e Setters
    public boolean isAll() { //Per select *
        return all;
    }

    public void setAll(boolean all) {
        this.all = all;
    }

    public boolean isDistinct() { //Per select distinct
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public Optional<String> getCondizioneWhere() { //Per le condizioni where < > ==
        return condizioneWhere;
    }

    public void setCondizioneWhere(Optional<String> condizioneWhere) {
        this.condizioneWhere = condizioneWhere;
    }

    public Optional<String> getValoriWhere() { //Per i valori where
        return valoriWhere;
    }

    public void setValoriWhere(Optional<String> valoriWhere) {
        this.valoriWhere = valoriWhere;
    }

    public Optional<String> getBoleani() { //Per aggiungere dei booleani
        return boleani;
    }

    public void setBoleani(Optional<String> boleani) {
        this.boleani = boleani;
    }

    public boolean isOrderBy() { //Per l'orderby
        return orderBy;
    }

    public void setOrderBy(boolean orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getTop() { //Per select top
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public boolean isMin() { //Per select min
        return min;
    }

    public void setMin(boolean min) {
        this.min = min;
    }

    public boolean isMax() { //Per select max
        return max;
    }

    public void setMax(boolean max) {
        this.max = max;
    }

    public boolean isCount() { //Per select count
        return count;
    }

    public void setCount(boolean count) {
        this.count = count;
    }

    public boolean isAvg() { //Per select avg
        return avg;
    }

    public void setAvg(boolean avg) {
        this.avg = avg;
    }

    public boolean isSum() {  //Per select sum
        return sum;
    }

    public void setSum(boolean sum) {
        this.sum = sum;
    }

    public Optional<String> getLike() { //Per like
        return like;
    }

    public void setLike(Optional<String> like) {
        this.like = like;
    }

    public Optional<String> getIn() { //Per where in
        return in;
    }

    public void setIn(Optional<String> in) {
        this.in = in;
    }

    public Optional<String[]> getBetween() { //Per where between
        return between;
    }

    public void setBetween(Optional<String[]> between) {
        this.between = between;
    }

    public Optional<String> getHaving() { //per where having
        return having;
    }

    public void setHaving(Optional<String> having) {
        this.having = having;
    }

    public int getLimit() { //Per limit 
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() { //Per offset
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}

