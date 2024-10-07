package com.my_app.my_app.dbG.API.Soap.NodeUser.Services.Classsssss;

import com.my_app.my_app.dbG.API.Soap.NodeUser.Services.Interfacceeeeeee.NodeUserServiceSoapI;
import com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione.NodeUser;
import com.my_app.my_app.dbG.Parametri.ParamQuery;
import com.my_app.my_app.dbG.Repository.Classsss.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.jws.WebService;
import java.util.List;

@Service
@WebService(endpointInterface = "com.my_app.my_app.dbG.API.Soap.SistemaDiRaccomandazione.Services.Interfacce.NodeUserServiceI")
public class NodeUserServiceSoap implements NodeUserServiceSoapI {

    @Autowired
    private UserRep userRep;

    
    public List<NodeUser> getUsers(ParamQuery paramQuery) {
        return userRep.findByDynamicQuery(paramQuery);
    }

    public void insertUser(NodeUser user) {
        userRep.insertNodeUser(user);
    }

    public void updateUser(NodeUser user) {
        userRep.updateNodeUser(user);
    }

    public void deleteUser(String userId) {
        userRep.deleteNodeUser(userId);
    }
}
