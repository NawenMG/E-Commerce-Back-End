package com.my_app.my_app.dbrel.JDBC.repository.classs;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.my_app.my_app.dbrel.JDBC.model.Users;
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryUsers;
import com.my_app.my_app.dbrel.JDBC.repository.interfacee.UsersRepI;

@Repository
public class UsersRep implements UsersRepI {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Query
    public List<Users> query(ParmQueryUsers parmQuery) {
        StringBuilder sql = new StringBuilder("SELECT ");

        if (parmQuery.isDistinct()) {
            sql.append("DISTINCT ");
        }

        if (parmQuery.isAll()) {
            sql.append("ALL ");
        }

        sql.append("* FROM Users ");

        if (parmQuery.getCondizioneWhere().isPresent()) {
            sql.append("WHERE ").append(parmQuery.getCondizioneWhere().get()).append(" ");
        }
        if (parmQuery.getValoriWhere().isPresent()) {
            sql.append(parmQuery.getValoriWhere().get()).append(" ");
        }
        if (parmQuery.getBoleani().isPresent()) {
            sql.append(parmQuery.getBoleani().get()).append(" ");
        }

        if (parmQuery.isOrderBy()) {
            sql.append("ORDER BY ").append(parmQuery.isOrderBy() ? "DESC " : "ASC ");
        }

        if (parmQuery.getTop() != null) {
            sql.insert(6, "TOP " + parmQuery.getTop() + " ");
        }

        if (parmQuery.isMin()) {
            sql.insert(6, "MIN ");
        }
        if (parmQuery.isMax()) {
            sql.insert(6, "MAX ");
        }
        if (parmQuery.isCount()) {
            sql.insert(6, "COUNT ");
        }
        if (parmQuery.isAvg()) {
            sql.insert(6, "AVG ");
        }
        if (parmQuery.isSum()) {
            sql.insert(6, "SUM ");
        }

        if (parmQuery.getLike().isPresent() && parmQuery.getCondizioneWhere().isPresent()) {
            sql.append("LIKE ").append(parmQuery.getLike().get()).append(" ");
        }

        return jdbcTemplate.query(sql.toString(), (rs, rowNum) -> new Users(
            rs.getInt("UsersID"),
            rs.getString("Nome"),
            rs.getString("Cognome"),
            rs.getString("Ruolo"),
            rs.getString("NomeUtente"),
            rs.getString("Email"),
            rs.getString("Password"),
            rs.getString("Immagine"),
            rs.getInt("Category")
        ));
    }

    // Per implementare il faker
    public void saveAll(List<Users> users) {
        String sql = "INSERT INTO Users (Nome, Cognome, Ruolo, NomeUtente, Email, Password, Immagine, Category) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        for (Users user : users) {
            jdbcTemplate.update(sql, 
                user.getNome(), 
                user.getCognome(), 
                user.getRuolo(), 
                user.getNomeUtente(), 
                user.getEmail(), 
                user.getPassword(), 
                user.getImmagine(), 
                user.getCategory()
            );
        }
    }

    // Insert
    public void insertUser(Users user) {
        String sql = "INSERT INTO Users (Nome, Cognome, Ruolo, NomeUtente, Email, Password, Immagine, Category) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, 
            user.getNome(), 
            user.getCognome(), 
            user.getRuolo(), 
            user.getNomeUtente(), 
            user.getEmail(), 
            user.getPassword(), 
            user.getImmagine(), 
            user.getCategory());
    }

    // Update
    public void updateUser(Users user) {
        String sql = "UPDATE Users SET Nome = ?, Cognome = ?, Ruolo = ?, NomeUtente = ?, Email = ?, Password = ?, Immagine = ?, Category = ? " +
                     "WHERE UsersID = ?";
        jdbcTemplate.update(sql, 
            user.getNome(), 
            user.getCognome(), 
            user.getRuolo(), 
            user.getNomeUtente(), 
            user.getEmail(), 
            user.getPassword(), 
            user.getImmagine(), 
            user.getCategory(), 
            user.getUsersID());
    }

    // Delete
    public void deleteUser(int userId) {
        String sql = "DELETE FROM Users WHERE UsersID = ?";
        jdbcTemplate.update(sql, userId);
    }
}
