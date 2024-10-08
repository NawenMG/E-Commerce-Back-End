package com.my_app.my_app.dbTS.API.Soap.AnalysisUser.Services.Classssss;

import com.my_app.my_app.dbTS.Models.AnalysisUser;
import com.my_app.my_app.dbTS.Parametri.ParamQuery;
import com.my_app.my_app.dbTS.Repository.Classss.AnalysisUserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import jakarta.jws.WebService;
import java.util.List;

@Service
@WebService(endpointInterface = "com.my_app.my_app.dbTS.API.Soap.AnalysisUser.Services.Interfaces.AnalysisUserServiceSoapI")
public class AnalysisUserServiceSoap implements com.my_app.my_app.dbTS.API.Soap.AnalysisUser.Services.Interfacceeeeeee.AnalysisUserServiceSoapI {

    @Autowired
    private AnalysisUserRep analysisUserRep;

    @PreAuthorize("hasRole('ADMIN')")
    public List<AnalysisUser> getUsers(ParamQuery paramQuery) {
        return analysisUserRep.query(paramQuery);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void insertUser(AnalysisUser user) {
        analysisUserRep.insertUser(user);
    }

    @PreAuthorize("hasRole('USER')")
    public void deleteUser(String measurement, String user, long startTime, long endTime) {
        analysisUserRep.deleteData(measurement, user, startTime, endTime);
    }

    @Override
    public void updateUser(AnalysisUser user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }
}
