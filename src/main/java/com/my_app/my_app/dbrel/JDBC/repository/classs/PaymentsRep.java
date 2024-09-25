package com.my_app.my_app.dbrel.JDBC.repository.classs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.my_app.my_app.dbrel.JDBC.Factories.Random.PaymentsFaker;
import com.my_app.my_app.dbrel.JDBC.model.Payments;
import com.my_app.my_app.dbrel.JDBC.parametri.ParamQuery;
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryPayments;
import com.my_app.my_app.dbrel.JDBC.repository.interfacee.PaymentsRepI;

@Repository
public class PaymentsRep implements PaymentsRepI {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // Query
    public List<Payments> query(ParamQuery paramQuery) {
        StringBuilder sql = new StringBuilder("SELECT ");

        if (paramQuery.isDistinct()) {
            sql.append("DISTINCT ");
        }

        if (paramQuery.isAll()) {
            sql.append("ALL ");
        }

        sql.append("* FROM Payments ");

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
            Payments payment = new Payments();
            payment.setPaymentsID(rs.getInt("PaymentsID"));
            payment.setType(rs.getString("Type"));
            payment.setData(rs.getDate("Data").toLocalDate());
            payment.setStatus(rs.getBoolean("Status"));
            payment.setTotal(rs.getDouble("Total"));
            return payment;
        });
    }

    // Per implementare il faker
      public void saveAll(int number) {
        String sql = "INSERT INTO Payments (PaymentsID, Type, Data, Status, Total) VALUES (?, ?, ?, ?, ?)";
        PaymentsFaker paymentsFaker = new PaymentsFaker();

        for (int i = 0; i < number; i++) {
            // Genera un pagamento fittizio
            Payments payment = paymentsFaker.generateFakePayment(number);

            // Salva il pagamento nel database
            jdbcTemplate.update(sql, 
                payment.getPaymentsID(), 
                payment.getType(), 
                payment.getData(), 
                payment.isStatus(), 
                payment.getTotal());
        }
    }

    // Insert
    public void insertPayment(Payments payment) {
        String sql = "INSERT INTO Payments (paymentsID, type, data, status, total) " +
                     "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, 
            payment.getPaymentsID(), 
            payment.getType(), 
            payment.getData(), 
            payment.isStatus(), 
            payment.getTotal());
    }

    // Update
    public void updatePayment(Payments payment) {
        String sql = "UPDATE Payments SET type = ?, data = ?, status = ?, total = ? " +
                     "WHERE paymentsID = ?";
        jdbcTemplate.update(sql, 
            payment.getType(), 
            payment.getData(), 
            payment.isStatus(), 
            payment.getTotal(), 
            payment.getPaymentsID());
    }

    // Delete
    public void deletePayment(int paymentsID) {
        String sql = "DELETE FROM Payments WHERE paymentsID = ?";
        jdbcTemplate.update(sql, paymentsID);
    }

    @Override
    public List<Payments> query(ParmQueryPayments parmQuery) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'query'");
    }
}
