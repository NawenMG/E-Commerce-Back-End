package com.my_app.my_app.dbrel.repository.interfacee;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.my_app.my_app.dbrel.model.Payments;
import com.my_app.my_app.dbrel.parametri.ParmQueryPayments;

@Repository
public interface PaymentsRepI {
    
    List<Payments> query(ParmQueryPayments parmQuery);
    void saveAll(List<Payments> payments);
    void insertPayment(Payments payment);
    void updatePayment(Payments payment);
    void deletePayment(int paymentsId);
}
