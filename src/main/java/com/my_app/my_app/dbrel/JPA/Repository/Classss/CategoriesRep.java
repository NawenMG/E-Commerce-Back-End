package com.my_app.my_app.dbrel.JPA.Repository.Classss;

import com.my_app.my_app.dbrel.JPA.Entity.Categories;
import com.my_app.my_app.dbrel.JPA.Entity.Orders;
import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Predicate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class CategoriesRep {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unused")
    public List<Categories> query(ParamQueryJpa paramQuery) {
        // Qui inizializziamo la query
        CriteriaBuilder cb = entityManager.getCriteriaBuilder(); 
        CriteriaQuery<Categories> cq = cb.createQuery(Categories.class); 
        Root<Categories> ordersRoot = cq.from(Categories.class); 
        
        List<Predicate> predicates = new ArrayList<>();

        // Distinct
        if (paramQuery.isDistinct()) {
            cq.distinct(true);
        }

        // Condizione Where
        if (paramQuery.getCondizioneWhere().isPresent() && paramQuery.getValoriWhere().isPresent()) {
            String condition = paramQuery.getCondizioneWhere().get();
            String value = paramQuery.getValoriWhere().get();
            Predicate wherePredicate = cb.equal(ordersRoot.get(condition), value);
            predicates.add(wherePredicate);
        }

        // Booleani
        if (paramQuery.getBoleani().isPresent()) {
            String booleanCondition = paramQuery.getBoleani().get();
            Predicate booleanPredicate = cb.equal(ordersRoot.get(booleanCondition), true); // Esempio di logica booleana
            predicates.add(booleanPredicate);
        }

        // Like
        if (paramQuery.getLike().isPresent()) {
            String likeValue = paramQuery.getLike().get();
            Predicate likePredicate = cb.like(ordersRoot.get("status"), "%" + likeValue + "%");
            predicates.add(likePredicate);
        }

        // Between
        if (paramQuery.getBetween().isPresent()) {
            String[] betweenValues = paramQuery.getBetween().get();
            if (betweenValues.length == 2) {
                Predicate betweenPredicate = cb.between(ordersRoot.get("orderDate"), LocalDate.parse(betweenValues[0]), LocalDate.parse(betweenValues[1]));
                predicates.add(betweenPredicate);
            }
        }

        // Aggiungere tutte le predicate alla query
        cq.where(cb.and(predicates.toArray(new Predicate[0])));

        // Operazioni Aggregate
        if (paramQuery.isCount()) {
            cq.multiselect(cb.count(ordersRoot));
        } else if (paramQuery.isSum()) {
            cq.multiselect(cb.sum(ordersRoot.get("quantity"))); // Cambiare "quantity" con l'attributo desiderato
        } else if (paramQuery.isAvg()) {
            cq.multiselect(cb.avg(ordersRoot.get("quantity"))); // Cambiare "quantity" con l'attributo desiderato
        } else if (paramQuery.isMin()) {
            cq.multiselect(cb.min(ordersRoot.get("quantity"))); // Cambiare "quantity" con l'attributo desiderato
        } else if (paramQuery.isMax()) {
            cq.multiselect(cb.max(ordersRoot.get("quantity"))); // Cambiare "quantity" con l'attributo desiderato
        } 

        // Order By
        if (paramQuery.isOrderBy()) {
            cq.orderBy(cb.asc(ordersRoot.get("orderDate"))); // Cambiare il campo come necessario
        }

        // Limit e Offset
        return entityManager.createQuery(cq)
                .setMaxResults(paramQuery.getLimit())
                .setFirstResult(paramQuery.getOffset())
                .getResultList();
    }

    // Insert
    public void insert(Categories categories) {
        entityManager.persist(categories);
    }

    // Update
    public void update(Categories categories) {
        entityManager.merge(categories);
    }

    // Metodo per eliminare un ordine per ID
    public void delete(Integer id) {
        Orders order = entityManager.find(Orders.class, id);
        if (order != null) {
            entityManager.remove(order);
        }
    }  
}
