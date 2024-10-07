package com.my_app.my_app.dbG.API.Soap.NodeUserLocation.Services.Interfacceeeeee;

import com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione.NodeUserLocation;
import com.my_app.my_app.dbG.Parametri.ParamQuery;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public interface NodeUserLocationSoapI {

    @WebMethod
    List<NodeUserLocation> getLocations(ParamQuery paramQuery);

    @WebMethod
    void insertLocation(NodeUserLocation location);

    @WebMethod
    void updateLocation(NodeUserLocation location);

    @WebMethod
    void deleteLocation(String userId);
}
