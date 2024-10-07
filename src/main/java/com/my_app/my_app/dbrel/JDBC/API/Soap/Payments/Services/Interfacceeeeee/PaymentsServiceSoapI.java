package com.my_app.my_app.dbrel.JDBC.API.Soap.Payments.Services.Interfacceeeeee;

import com.my_app.my_app.dbrel.JDBC.model.Payments;
import com.my_app.my_app.dbrel.JDBC.parametri.ParamQuery;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public interface PaymentsServiceSoapI {

    @WebMethod
    List<Payments> getPayments(ParamQuery paramQuery);

    @WebMethod
    void insertPayment(Payments payment);

    @WebMethod
    void updatePayment(Payments payment);

    @WebMethod
    void deletePayment(int paymentId);
}
