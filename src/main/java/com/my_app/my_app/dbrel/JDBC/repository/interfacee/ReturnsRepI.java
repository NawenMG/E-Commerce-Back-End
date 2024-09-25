package com.my_app.my_app.dbrel.JDBC.repository.interfacee;

import java.util.List;

import com.my_app.my_app.dbrel.JDBC.model.Returns;
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryReturns;

public interface ReturnsRepI {
    List<Returns> query(ParmQueryReturns parmQuery);
    void saveAll(int number);
    void insertReturn(Returns returns);
    void updateReturn(Returns returns);
    void deleteReturn(int returnsID);
}
