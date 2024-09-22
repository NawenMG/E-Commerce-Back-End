package com.my_app.my_app.dbrel.JPA.Repository.Classss;

import com.my_app.my_app.dbrel.JPA.Entity.Returns;
import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;


public class ReturnsRep {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unused")
    public List<Returns> query(ParamQueryJpa paramQuery) {
        // Inizializzazione della query
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Returns> cq = cb.createQuery(Returns.class);
        Root<Returns> returnsRoot = cq.from(Returns.class);

        List<Predicate> predicates = new ArrayList<>();

        // Distinct
        if (paramQuery.isDistinct()) {
            cq.distinct(true);
        }

        // Condizione Where
        if (paramQuery.getCondizioneWhere().isPresent() && paramQuery.getValoriWhere().isPresent()) {
            String condition = paramQuery.getCondizioneWhere().get();
            String value = paramQuery.getValoriWhere().get();
            Predicate wherePredicate = cb.equal(returnsRoot.get(condition), value);
            predicates.add(wherePredicate);
        }

        // Aggiungere logica per booleani
        if (paramQuery.getBoleani().isPresent()) {
            String booleanValue = paramQuery.getBoleani().get();
            Predicate statusPredicate = cb.equal(returnsRoot.get("Status"), booleanValue);
            predicates.add(statusPredicate);
        }

        // Aggiungere tutte le predicate alla query
        cq.where(cb.and(predicates.toArray(new Predicate[0])));

        // Operazioni Aggregate
        if (paramQuery.isCount()) {
            cq.multiselect(cb.count(returnsRoot));
        } else if (paramQuery.isSum()) {
        } else if (paramQuery.isAvg()) {
        } else if (paramQuery.isMin()) {
        } else if (paramQuery.isMax()) {
        }

        // Order By
        if (paramQuery.isOrderBy()) {
            cq.orderBy(cb.asc(returnsRoot.get("DataRichiesta"))); 
        }

        // Limit e Offset
        return entityManager.createQuery(cq)
                .setMaxResults(paramQuery.getLimit())
                .setFirstResult(paramQuery.getOffset())
                .getResultList();
    }

    // Insert
    public void insert(Returns returns) {
        entityManager.persist(returns);
    }

    // Update
    public void update(Returns returns) {
        entityManager.merge(returns);
    }

    // Metodo per eliminare un ritorno per ID
    public void delete(Integer id) {
        Returns returns = entityManager.find(Returns.class, id);
        if (returns != null) {
            entityManager.remove(returns);
        }
    }
}
