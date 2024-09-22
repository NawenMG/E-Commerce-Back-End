package com.my_app.my_app.dbrel.JPA.Repository.Classss;

import com.my_app.my_app.dbrel.JPA.Entity.Payments;
import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;


public class PaymentsRep  {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unused")
    public List<Payments> query(ParamQueryJpa paramQuery) {
        // Inizializzazione della query
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Payments> cq = cb.createQuery(Payments.class);
        Root<Payments> paymentsRoot = cq.from(Payments.class);

        List<Predicate> predicates = new ArrayList<>();

        // Distinct
        if (paramQuery.isDistinct()) {
            cq.distinct(true);
        }

        // Condizione Where
        if (paramQuery.getCondizioneWhere().isPresent() && paramQuery.getValoriWhere().isPresent()) {
            String condition = paramQuery.getCondizioneWhere().get();
            String value = paramQuery.getValoriWhere().get();
            Predicate wherePredicate = cb.equal(paymentsRoot.get(condition), value);
            predicates.add(wherePredicate);
        }

        // Booleani
        if (paramQuery.getBoleani().isPresent()) {
            String booleanCondition = paramQuery.getBoleani().get();
            Predicate booleanPredicate = cb.equal(paymentsRoot.get(booleanCondition), true); // Modifica se necessario
            predicates.add(booleanPredicate);
        }

        // Like
        if (paramQuery.getLike().isPresent()) {
            String likeValue = paramQuery.getLike().get();
            Predicate likePredicate = cb.like(paymentsRoot.get("Type"), "%" + likeValue + "%");
            predicates.add(likePredicate);
        }

        // Between
        if (paramQuery.getBetween().isPresent()) {
            String[] betweenValues = paramQuery.getBetween().get();
            if (betweenValues.length == 2) {
                Predicate betweenPredicate = cb.between(paymentsRoot.get("Data"), betweenValues[0], betweenValues[1]);
                predicates.add(betweenPredicate);
            }
        }

        // Aggiungere tutte le predicate alla query
        cq.where(cb.and(predicates.toArray(new Predicate[0])));

        // Operazioni Aggregate
        if (paramQuery.isCount()) {
            cq.multiselect(cb.count(paymentsRoot));
        } else if (paramQuery.isSum()) {
            cq.multiselect(cb.sum(paymentsRoot.get("Total"))); // Cambiare "Total" con l'attributo desiderato
        } else if (paramQuery.isAvg()) {
            cq.multiselect(cb.avg(paymentsRoot.get("Total"))); // Cambiare "Total" con l'attributo desiderato
        } else if (paramQuery.isMin()) {
            cq.multiselect(cb.min(paymentsRoot.get("Total"))); // Cambiare "Total" con l'attributo desiderato
        } else if (paramQuery.isMax()) {
            cq.multiselect(cb.max(paymentsRoot.get("Total"))); // Cambiare "Total" con l'attributo desiderato
        }

        // Order By
        if (paramQuery.isOrderBy()) {
            cq.orderBy(cb.asc(paymentsRoot.get("Data"))); // Cambiare il campo come necessario
        }

        // Limit e Offset
        return entityManager.createQuery(cq)
                .setMaxResults(paramQuery.getLimit())
                .setFirstResult(paramQuery.getOffset())
                .getResultList();
    }

    // Insert
    public void insert(Payments payment) {
        entityManager.persist(payment);
    }

    // Update
    public void update(Payments payment) {
        entityManager.merge(payment);
    }

    // Metodo per eliminare un pagamento per ID
    public void delete(Integer id) {
        Payments payment = entityManager.find(Payments.class, id);
        if (payment != null) {
            entityManager.remove(payment);
        }
    }
}
