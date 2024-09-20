package com.my_app.my_app.dbrel.repository.interfacee;

import java.util.List;
import com.my_app.my_app.dbrel.model.Returns;
import com.my_app.my_app.dbrel.parametri.ParmQueryReturns;

public interface ReturnsRepI {
    List<Returns> query(ParmQueryReturns parmQuery);
    void saveAll(List<Returns> returns);
    void insertReturn(Returns returns);
    void updateReturn(Returns returns);
    void deleteReturn(int returnsID);
}
