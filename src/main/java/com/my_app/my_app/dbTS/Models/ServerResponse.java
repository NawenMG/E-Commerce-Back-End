package com.my_app.my_app.dbTS.Models;

import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;
import org.threeten.bp.ZonedDateTime;

@Measurement(name = "ServerResponse")
public class ServerResponse {
    // Tag
    @Column(name = "Server")
    private String server; 

    @Column(name = "Endpoint")
    private String endpoint; 

    // Field
    @Column(name = "ResponseTimeAverage")
    private double responseTimeAverage; 

    @Column(name = "RequestNumbers")
    private int requestNumbers; 

    @Column(name = "ErrorsNumbers")
    private int errorsNumbers; 

    // Timestamp
    @Column(name = "TimeStamp")
    private ZonedDateTime timeStamp; 

    public ServerResponse() {
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public double getResponseTimeAverage() {
        return responseTimeAverage;
    }

    public void setResponseTimeAverage(double responseTimeAverage) {
        this.responseTimeAverage = responseTimeAverage;
    }

    public int getRequestNumbers() {
        return requestNumbers;
    }

    public void setRequestNumbers(int requestNumbers) {
        this.requestNumbers = requestNumbers;
    }

    public int getErrorsNumbers() {
        return errorsNumbers;
    }

    public void setErrorsNumbers(int errorsNumbers) {
        this.errorsNumbers = errorsNumbers;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(ZonedDateTime timeStamp) {
        if (timeStamp == null) {
            throw new IllegalArgumentException("Timestamp cannot be null");
        }
        this.timeStamp = timeStamp;
    }
}
