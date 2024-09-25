package com.my_app.my_app.dbrel.JDBC.repository.classs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.my_app.my_app.dbrel.JDBC.model.Categories;
import com.my_app.my_app.dbrel.JDBC.parametri.ParamQuery;
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryCategories;
import com.my_app.my_app.dbrel.JDBC.repository.interfacee.CategoriesRepI;

@Repository
public class CategoriesRep implements CategoriesRepI {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // Query
    public List<Categories> query(ParamQuery paramQuery) {
        StringBuilder sql = new StringBuilder("SELECT ");

        if (paramQuery.isDistinct()) {
            sql.append("DISTINCT ");
        }

        if (paramQuery.isAll()) {
            sql.append("ALL ");
        }

        sql.append("* FROM Categories ");

        // Condizione WHERE
        if (paramQuery.getCondizioneWhere().isPresent()) {
            sql.append("WHERE ").append(paramQuery.getCondizioneWhere().get()).append(" ");
        }

        if (paramQuery.getValoriWhere().isPresent()) {
            sql.append(paramQuery.getValoriWhere().get()).append(" ");
        }

        if (paramQuery.getBoleani().isPresent()) {
            sql.append(paramQuery.getBoleani().get()).append(" ");
        }

        // Ordinamento
        if (paramQuery.isOrderBy()) {
            sql.append("ORDER BY ").append(paramQuery.isOrderBy() ? "DESC " : "ASC ");
        }

        // TOP, MIN, MAX, COUNT, AVG, SUM
        if (paramQuery.getTop() != null) {
            sql.insert(6, "TOP " + paramQuery.getTop() + " ");
        }

        if (paramQuery.isMin()) {
            sql.insert(6, "MIN ");
        }
        if (paramQuery.isMax()) {
            sql.insert(6, "MAX ");
        }
        if (paramQuery.isCount()) {
            sql.insert(6, "COUNT ");
        }
        if (paramQuery.isAvg()) {
            sql.insert(6, "AVG ");
        }
        if (paramQuery.isSum()) {
            sql.insert(6, "SUM ");
        }

        // LIKE
        if (paramQuery.getLike().isPresent() && paramQuery.getCondizioneWhere().isPresent()) {
            sql.append("LIKE ").append(paramQuery.getLike().get()).append(" ");
        }

        // Esecuzione della query
        Map<String, Object> params = new HashMap<>();
        // Aggiungi qui la logica per popolare 'params' se necessario

        return namedParameterJdbcTemplate.query(sql.toString(), params, (rs, rowNum) -> {
            Categories category = new Categories();
            category.setCategoriesID(rs.getInt("CategoriesID"));
            category.setName(rs.getString("Name"));
            return category;
        });
    }

    // Per implementare il faker
    public void saveAll(List<Categories> categories) {
        String sql = "INSERT INTO Categories (Name) VALUES (?)";
        
        for (Categories category : categories) {
            jdbcTemplate.update(sql, 
                category.getName()
            );
        }
    }

    // Insert
    public void insertCategory(Categories category) {
        String sql = "INSERT INTO Categories (CategoriesID, Name) VALUES (?, ?)";
        jdbcTemplate.update(sql, 
            category.getCategoriesID(), 
            category.getName()
        );
    }

    // Update
    public void updateCategory(Categories category) {
        String sql = "UPDATE Categories SET Name = ? WHERE CategoriesID = ?";
        jdbcTemplate.update(sql, 
            category.getName(), 
            category.getCategoriesID()
        );
    }

    // Delete
    public void deleteCategory(int categoriesID) {
        String sql = "DELETE FROM Categories WHERE CategoriesID = ?";
        jdbcTemplate.update(sql, categoriesID);
    }

    @Override
    public List<Categories> query(ParmQueryCategories parmQuery) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'query'");
    }
}
