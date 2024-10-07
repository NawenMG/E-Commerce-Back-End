package com.my_app.my_app.dbG.API.Soap.NodeUserLocation.Services.Classssss;

import com.my_app.my_app.dbG.API.Soap.NodeUserLocation.Services.Interfacceeeeee.NodeUserLocationSoapI;
import com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione.NodeUserLocation;
import com.my_app.my_app.dbG.Parametri.ParamQuery;
import com.my_app.my_app.dbG.Repository.Classsss.UserLocationRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.jws.WebService;
import java.util.List;

@Service
@WebService(endpointInterface = "com.my_app.my_app.dbG.API.Soap.NodeUserLocation.Services.Interfacceeeeeee.NodeUserLocationServiceSoapI")
public class NodeUserLocationSoap implements NodeUserLocationSoapI {

    @Autowired
    private UserLocationRep userLocationRep;

    @Override
    public List<NodeUserLocation> getLocations(ParamQuery paramQuery) {
        return userLocationRep.findByDynamicQuery(paramQuery);
    }

    @Override
    public void insertLocation(NodeUserLocation location) {
        userLocationRep.insertNodeUserLocation(location);
    }

    @Override
    public void updateLocation(NodeUserLocation location) {
        userLocationRep.updateNodeUserLocation(location);
    }

    @Override
    public void deleteLocation(String locationId) {
        userLocationRep.deleteNodeUserLocation(locationId);
    }
}
