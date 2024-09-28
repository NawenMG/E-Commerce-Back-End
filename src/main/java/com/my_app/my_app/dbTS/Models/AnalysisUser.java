package com.my_app.my_app.dbTS.Models;

import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;
import org.threeten.bp.ZonedDateTime;

import jakarta.validation.constraints.NotBlank;

@Measurement(name = "AnalysisUser")
public class AnalysisUser {
    // TAG
    @Column(name = "User")
    @NotBlank(message = "Obbligatorio")
    private String user;

    @Column(name = "TypeDevice")
    @NotBlank(message = "Obbligatorio")
    private String typeDevice;

    @Column(name = "Action")
    @NotBlank(message = "Obbligatorio")
    private String action;

    // Field
    @Column(name = "DuringAction")
    @NotBlank(message = "Obbligatorio")
    private Long duringAction; 

    // Timestamp
    @Column(name = "TimeStamp")
    @NotBlank(message = "Obbligatorio")
    private ZonedDateTime timestamp; //ZonedDateTime per gestire i fusi orari

    public AnalysisUser() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTypeDevice() {
        return typeDevice;
    }

    public void setTypeDevice(String typeDevice) {
        this.typeDevice = typeDevice;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getDuringAction() {
        return duringAction;
    }

    public void setDuringAction(Long duringAction) {
        this.duringAction = duringAction;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimeStamp(ZonedDateTime timeStamp) {
        if (timeStamp == null) {
            throw new IllegalArgumentException("Timestamp cannot be null");
        }
        this.timestamp = timeStamp;
    }
}
