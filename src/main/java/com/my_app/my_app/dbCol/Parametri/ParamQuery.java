package com.my_app.my_app.dbCol.Parametri;

import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class ParamQuery {
    private boolean distinct = false;
    private Optional<String> condizioneWhere = Optional.empty();
    private Optional<String> valoriWhere = Optional.empty();
    private Optional<String> boleani = Optional.empty();
    private boolean orderBy = false;
    private Integer limit = 100; 
    private Integer offset = null; 
    private Optional<String> like = Optional.empty();
    private Optional<String> in = Optional.empty();
    private Optional<String[]> between = Optional.empty();
    private Optional<String> having = Optional.empty();

    public ParamQuery() {
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

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
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
}
