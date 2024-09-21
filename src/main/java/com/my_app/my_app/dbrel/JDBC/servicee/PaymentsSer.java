package com.my_app.my_app.dbrel.JDBC.servicee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.my_app.my_app.dbrel.JDBC.Factories.Random.PaymentsFaker;
import com.my_app.my_app.dbrel.JDBC.model.Payments;
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryPayments;
import com.my_app.my_app.dbrel.JDBC.repository.interfacee.PaymentsRepI;

@Service
public class PaymentsSer {

    @Autowired
    private PaymentsRepI paymentsRepI;

    // Query
    public List<Payments> queryService(ParmQueryPayments parmQuery) {
        return paymentsRepI.query(parmQuery);
    }

    // Servizio per il faker
    public void saveAllService(int numberOfPayments) {
        List<Payments> payments = PaymentsFaker.createPayments(numberOfPayments);
        paymentsRepI.saveAll(payments);
    }

    // Inserimento di un pagamento
    public void insertPaymentService(Payments payment) {
        paymentsRepI.insertPayment(payment);
    }

    // Aggiornamento di un pagamento
    public void updatePaymentService(Payments payment) {
        paymentsRepI.updatePayment(payment);
    }

    // Eliminazione di un pagamento
    public void deletePaymentService(int paymentsId) {
        paymentsRepI.deletePayment(paymentsId);
    }
}

