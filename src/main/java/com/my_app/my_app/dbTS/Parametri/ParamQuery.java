package com.my_app.my_app.dbTS.Parametri;

import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class ParamQuery {
    private Optional<String> measurement = Optional.empty();
    private Optional<String> timeRangeStart = Optional.empty();
    private Optional<String> timeRangeEnd = Optional.empty();
    private Optional<String> whereClause = Optional.empty();
    private Optional<String> orderBy = Optional.empty();
    private int limit = 40;
    private int offset = 0;

    public ParamQuery() {
    }

    // Getters e Setters
    public Optional<String> getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Optional<String> measurement) {
        this.measurement = measurement;
    }

    public Optional<String> getTimeRangeStart() {
        return timeRangeStart;
    }

    public void setTimeRangeStart(Optional<String> timeRangeStart) {
        this.timeRangeStart = timeRangeStart;
    }

    public Optional<String> getTimeRangeEnd() {
        return timeRangeEnd;
    }

    public void setTimeRangeEnd(Optional<String> timeRangeEnd) {
        this.timeRangeEnd = timeRangeEnd;
    }

    public Optional<String> getWhereClause() {
        return whereClause;
    }

    public void setWhereClause(Optional<String> whereClause) {
        this.whereClause = whereClause;
    }

    public Optional<String> getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Optional<String> orderBy) {
        this.orderBy = orderBy;
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
