package com.my_app.my_app.dbrel.JDBC.API.Soap.Payments.Services.Classssss;

import com.my_app.my_app.dbrel.JDBC.API.Soap.Payments.Services.Interfacceeeeee.PaymentsServiceSoapI;
import com.my_app.my_app.dbrel.JDBC.model.Payments;
import com.my_app.my_app.dbrel.JDBC.parametri.ParamQuery;
import com.my_app.my_app.dbrel.JDBC.repository.classs.PaymentsRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.jws.WebService;
import java.util.List;

@Service
@WebService(endpointInterface = "com.my_app.my_app.dbG.API.Soap.Payments.Services.Interfacce.PaymentsServiceSoapI")
public class PaymentsServiceSoap implements PaymentsServiceSoapI {

    @Autowired
    private PaymentsRep paymentsRep;

    public List<Payments> getPayments(ParamQuery paramQuery) {
        return paymentsRep.query(paramQuery);
    }

    public void insertPayment(Payments payment) {
        paymentsRep.insertPayment(payment);
    }

    public void updatePayment(Payments payment) {
        paymentsRep.updatePayment(payment);
    }

    public void deletePayment(int paymentId) {
        paymentsRep.deletePayment(paymentId);
    }
}
