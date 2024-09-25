package com.my_app.my_app.dbrel.JDBC.repository.classs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.my_app.my_app.dbrel.JDBC.Factories.Random.OrdersFaker;
import com.my_app.my_app.dbrel.JDBC.model.Orders;
import com.my_app.my_app.dbrel.JDBC.parametri.ParamQuery; // Assicurati di adattare i parametri se necessario
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryOrders;
import com.my_app.my_app.dbrel.JDBC.repository.interfacee.OrdersRepI; // Crea l'interfaccia OrdersRepI se non esiste

@Repository
public class OrdersRep implements OrdersRepI {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // Query
    public List<Orders> query(ParamQuery paramQuery) {
        StringBuilder sql = new StringBuilder("SELECT ");

        if (paramQuery.isDistinct()) {
            sql.append("DISTINCT ");
        }

        if (paramQuery.isAll()) {
            sql.append("ALL ");
        }

        sql.append("* FROM Orders ");

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
        // Popola 'params' se necessario

        return namedParameterJdbcTemplate.query(sql.toString(), params, (rs, rowNum) -> {
            Orders order = new Orders();
            order.setOrderID(rs.getInt("OrderID"));
            order.setUsersID(rs.getInt("UsersID"));
            order.setStatoDiSpedizione(rs.getTime("StatoDiSpedizione").toLocalTime());
            order.setDataDiConsegna(rs.getDate("DataDiConsegna").toLocalDate());
            order.setDataDiRichiesta(rs.getDate("DataDiRichiesta").toLocalDate());
            order.setAccettazioneOrdine(rs.getBoolean("AccettazioneOrdine"));
            order.setStatus(rs.getBoolean("Status"));
            order.setCorriere(rs.getString("Corriere"));
            order.setPosizione(rs.getString("Posizione"));
            return order;
        });
    }

    // Per implementare il faker
    public void saveAll(int number) {
        String sql = "INSERT INTO Orders (OrderID, UsersID, StatoDiSpedizione, DataDiConsegna, DataDiRichiesta, AccettazioneOrdine, Status, Corriere, Posizione) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        OrdersFaker ordersFaker = new OrdersFaker();

        for (int i = 0; i < number; i++) {
            // Genera un ordine fittizio
            Orders order = ordersFaker.generateFakeOrder(number);

            // Salva l'ordine nel database
            jdbcTemplate.update(sql, 
                order.getOrderID(), 
                order.getUsersID(), 
                order.getStatoDiSpedizione(), 
                order.getDataDiConsegna(), 
                order.getDataDiRichiesta(), 
                order.isAccettazioneOrdine(), 
                order.isStatus(), 
                order.getCorriere(), 
                order.getPosizione());
        }
    }

    // Insert
    public void insertOrder(Orders order) {
        String sql = "INSERT INTO Orders (UsersID, StatoDiSpedizione, DataDiConsegna, DataDiRichiesta, AccettazioneOrdine, Status, Corriere, Posizione) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, 
            order.getUsersID(), 
            order.getStatoDiSpedizione(), 
            order.getDataDiConsegna(), 
            order.getDataDiRichiesta(), 
            order.isAccettazioneOrdine(), 
            order.isStatus(), 
            order.getCorriere(), 
            order.getPosizione());
    }

    // Update
    public void updateOrder(Orders order) {
        String sql = "UPDATE Orders SET UsersID = ?, StatoDiSpedizione = ?, DataDiConsegna = ?, DataDiRichiesta = ?, AccettazioneOrdine = ?, Status = ?, Corriere = ?, Posizione = ? " +
                     "WHERE OrderID = ?";
        jdbcTemplate.update(sql, 
            order.getUsersID(), 
            order.getStatoDiSpedizione(), 
            order.getDataDiConsegna(), 
            order.getDataDiRichiesta(), 
            order.isAccettazioneOrdine(), 
            order.isStatus(), 
            order.getCorriere(), 
            order.getPosizione(), 
            order.getOrderID());
    }

    // Delete
    public void deleteOrder(int orderID) {
        String sql = "DELETE FROM Orders WHERE OrderID = ?";
        jdbcTemplate.update(sql, orderID);
    }

    @Override
    public List<Orders> query(ParmQueryOrders parmQuery) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'query'");
    }
}
