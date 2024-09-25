package com.my_app.my_app.dbrel.JDBC.repository.classs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.my_app.my_app.dbrel.JDBC.model.Returns;
import com.my_app.my_app.dbrel.JDBC.parametri.ParamQuery;
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryReturns;
import com.my_app.my_app.dbrel.JDBC.repository.interfacee.ReturnsRepI;

@Repository
public class ReturnsRep implements ReturnsRepI {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // Query
    public List<Returns> query(ParamQuery paramQuery) {
        StringBuilder sql = new StringBuilder("SELECT ");

        if (paramQuery.isDistinct()) {
            sql.append("DISTINCT ");
        }

        if (paramQuery.isAll()) {
            sql.append("ALL ");
        }

        sql.append("* FROM Returns ");

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

        // Esecuzione della query
        Map<String, Object> params = new HashMap<>();
        // Aggiungi qui la logica per popolare 'params' se necessario

        return namedParameterJdbcTemplate.query(sql.toString(), params, (rs, rowNum) -> {
            Returns returnObj = new Returns();
            returnObj.setReturnsID(rs.getInt("ReturnsID"));
            returnObj.setUsersID(rs.getInt("UsersID"));
            returnObj.setStatus(rs.getBoolean("Status"));
            returnObj.setAccettazioneReso(rs.getBoolean("AccettazioneReso"));
            returnObj.setDataRichiesta(rs.getDate("DataRichiesta").toLocalDate());
            return returnObj;
        });
    }

    // Save All
    public void saveAll(List<Returns> returns) {
        String sql = "INSERT INTO Returns (UsersID, Status, AccettazioneReso, DataRichiesta) VALUES (?, ?, ?, ?)";
        
        for (Returns returnObj : returns) {
            jdbcTemplate.update(sql, 
                returnObj.getUsersID(), 
                returnObj.isStatus(), 
                returnObj.isAccettazioneReso(), 
                returnObj.getDataRichiesta()
            );
        }
    }

    // Insert
    public void insertReturn(Returns returnObj) {
        String sql = "INSERT INTO Returns (returnsID, UsersID, Status, AccettazioneReso, DataRichiesta) " +
                     "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, 
            returnObj.getReturnsID(), 
            returnObj.getUsersID(), 
            returnObj.isStatus(), 
            returnObj.isAccettazioneReso(), 
            returnObj.getDataRichiesta());
    }

    // Update
    public void updateReturn(Returns returnObj) {
        String sql = "UPDATE Returns SET UsersID = ?, Status = ?, AccettazioneReso = ?, DataRichiesta = ? " +
                     "WHERE returnsID = ?";
        jdbcTemplate.update(sql, 
            returnObj.getUsersID(), 
            returnObj.isStatus(), 
            returnObj.isAccettazioneReso(), 
            returnObj.getDataRichiesta(), 
            returnObj.getReturnsID());
    }

    // Delete
    public void deleteReturn(int returnsID) {
        String sql = "DELETE FROM Returns WHERE returnsID = ?";
        jdbcTemplate.update(sql, returnsID);
    }

    @Override
    public List<Returns> query(ParmQueryReturns parmQuery) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'query'");
    }
}
