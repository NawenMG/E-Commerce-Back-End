package com.my_app.my_app.dbrel.JPA.Repository.Classss;

import com.my_app.my_app.dbrel.JPA.Entity.Products;
import com.my_app.my_app.dbrel.JPA.Parametri.ParamQueryJpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;


public class ProductsRep {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unused")
    public List<Products> query(ParamQueryJpa paramQuery) {
        // Inizializzazione della query
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Products> cq = cb.createQuery(Products.class);
        Root<Products> productsRoot = cq.from(Products.class);

        List<Predicate> predicates = new ArrayList<>();

        // Distinct
        if (paramQuery.isDistinct()) {
            cq.distinct(true);
        }

        // Condizione Where
        if (paramQuery.getCondizioneWhere().isPresent() && paramQuery.getValoriWhere().isPresent()) {
            String condition = paramQuery.getCondizioneWhere().get();
            String value = paramQuery.getValoriWhere().get();
            Predicate wherePredicate = cb.equal(productsRoot.get(condition), value);
            predicates.add(wherePredicate);
        }

        // Booleani
        if (paramQuery.getBoleani().isPresent()) {
            String booleanCondition = paramQuery.getBoleani().get();
            Predicate booleanPredicate = cb.equal(productsRoot.get(booleanCondition), true); // Modifica se necessario
            predicates.add(booleanPredicate);
        }

        // Like
        if (paramQuery.getLike().isPresent()) {
            String likeValue = paramQuery.getLike().get();
            Predicate likePredicate = cb.like(productsRoot.get("nome"), "%" + likeValue + "%");
            predicates.add(likePredicate);
        }

        // Between
        if (paramQuery.getBetween().isPresent()) {
            String[] betweenValues = paramQuery.getBetween().get();
            if (betweenValues.length == 2) {
                Predicate betweenPredicate = cb.between(productsRoot.get("dataDiInserimento"), betweenValues[0], betweenValues[1]);
                predicates.add(betweenPredicate);
            }
        }

        // Aggiungere tutte le predicate alla query
        cq.where(cb.and(predicates.toArray(new Predicate[0])));

        // Operazioni Aggregate
        if (paramQuery.isCount()) {
            cq.multiselect(cb.count(productsRoot));
        } else if (paramQuery.isSum()) {
            cq.multiselect(cb.sum(productsRoot.get("prezzo"))); // Cambiare "prezzo" con l'attributo desiderato
        } else if (paramQuery.isAvg()) {
            cq.multiselect(cb.avg(productsRoot.get("prezzo"))); // Cambiare "prezzo" con l'attributo desiderato
        } else if (paramQuery.isMin()) {
            cq.multiselect(cb.min(productsRoot.get("prezzo"))); // Cambiare "prezzo" con l'attributo desiderato
        } else if (paramQuery.isMax()) {
            cq.multiselect(cb.max(productsRoot.get("prezzo"))); // Cambiare "prezzo" con l'attributo desiderato
        }

        // Order By
        if (paramQuery.isOrderBy()) {
            cq.orderBy(cb.asc(productsRoot.get("nome"))); // Cambiare il campo come necessario
        }

        // Limit e Offset
        return entityManager.createQuery(cq)
                .setMaxResults(paramQuery.getLimit())
                .setFirstResult(paramQuery.getOffset())
                .getResultList();
    }

    // Insert
    public void insert(Products product) {
        entityManager.persist(product);
    }

    // Update
    public void update(Products product) {
        entityManager.merge(product);
    }

    // Metodo per eliminare un prodotto per ID
    public void delete(Integer id) {
        Products product = entityManager.find(Products.class, id);
        if (product != null) {
            entityManager.remove(product);
        }
    }
}
