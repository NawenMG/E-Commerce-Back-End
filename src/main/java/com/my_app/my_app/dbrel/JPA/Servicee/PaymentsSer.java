package com.my_app.my_app.dbrel.JPA.Servicee;

import com.my_app.my_app.dbrel.JPA.Entity.Payments;
import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;
import com.my_app.my_app.dbrel.JPA.Repository.Classss.PaymentsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentsSer {

    @Autowired
    private PaymentsRep paymentsRep;

    // Query per ottenere i pagamenti in base ai parametri
    public List<Payments> query(ParamQueryJpa paramQuery) {
        return paymentsRep.query(paramQuery);
    }

    // Inserire un nuovo pagamento
    public void insert(Payments payment) {
        paymentsRep.insert(payment);
    }

    // Aggiornare un pagamento esistente
    public void update(Payments payment) {
        paymentsRep.update(payment);
    }

    // Eliminare un pagamento per ID
    public void delete(Integer id) {
        paymentsRep.delete(id);
    }
}
