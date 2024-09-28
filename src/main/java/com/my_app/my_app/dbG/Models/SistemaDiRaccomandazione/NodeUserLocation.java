package com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

import jakarta.validation.constraints.NotBlank;

@Node
public class NodeUserLocation {
    @Id
    @NotBlank(message = "Obbligatorio")
    private String locationId;

    @NotBlank(message = "Obbligatorio")
    private String city;

    @NotBlank(message = "Obbligatorio")
    private String country;

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
