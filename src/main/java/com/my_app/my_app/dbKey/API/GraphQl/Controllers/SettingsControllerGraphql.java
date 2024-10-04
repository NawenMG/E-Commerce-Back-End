package com.my_app.my_app.dbKey.API.GraphQl.Controllers;

import com.my_app.my_app.dbKey.Models.Settings;
import com.my_app.my_app.dbKey.Parametri.ParamQuery;
import com.my_app.my_app.dbKey.Repository.Classss.SettingsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettingsControllerGraphql {
    
    @Autowired
    private SettingsRep settingsRep;    

    @QueryMapping
    public List<Settings> getSettings(@Argument ParamQuery params) {
        return settingsRep.search(params);
    }
}
