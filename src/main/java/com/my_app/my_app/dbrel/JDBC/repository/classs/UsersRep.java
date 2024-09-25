package com.my_app.my_app.dbrel.JDBC.repository.classs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.my_app.my_app.dbrel.JDBC.Factories.Random.UsersFaker;
import com.my_app.my_app.dbrel.JDBC.model.Users;
import com.my_app.my_app.dbrel.JDBC.parametri.ParamQuery;
import com.my_app.my_app.dbrel.JDBC.parametri.ParmQueryUsers;
import com.my_app.my_app.dbrel.JDBC.repository.interfacee.UsersRepI;

@Repository
public class UsersRep implements UsersRepI {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // Query
    public List<Users> query(ParamQuery paramQuery) {
        StringBuilder sql = new StringBuilder("SELECT ");

        if (paramQuery.isDistinct()) {
            sql.append("DISTINCT ");
        }

        if (paramQuery.isAll()) {
            sql.append("ALL ");
        }

        sql.append("* FROM Users ");

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
            Users user = new Users();
            user.setUsersID(rs.getInt("UsersID"));
            user.setNome(rs.getString("Nome"));
            user.setCognome(rs.getString("Cognome"));
            user.setRuolo(rs.getString("Ruolo"));
            user.setNomeUtente(rs.getString("NomeUtente"));
            user.setEmail(rs.getString("Email"));
            user.setPassword(rs.getString("Password"));
            user.setImmagine(rs.getString("Immagine"));
            user.setCategory(rs.getInt("Category"));
            return user;
        });
    }

    // Save All
    public void saveAll(int number) {
        String sql = "INSERT INTO Users (UsersID, Nome, Cognome, Ruolo, NomeUtente, Email, Password, Immagine, Category) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        UsersFaker usersFaker = new UsersFaker();

        for (int i = 0; i < number; i++) {
            // Genera un utente fittizio
            Users userInstance = usersFaker.generateFakeUser(number);

            // Salva l'utente nel database
            jdbcTemplate.update(sql, 
                userInstance.getUsersID(), 
                userInstance.getNome(), 
                userInstance.getCognome(), 
                userInstance.getRuolo(), 
                userInstance.getNomeUtente(), 
                userInstance.getEmail(), 
                userInstance.getPassword(), 
                userInstance.getImmagine(), 
                userInstance.getCategory());
        }
    }

    // Insert
    public void insertUser(Users user) {
        String sql = "INSERT INTO Users (usersID, Nome, Cognome, Ruolo, NomeUtente, Email, Password, Immagine, Category) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, 
            user.getUsersID(), 
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
                     "WHERE usersID = ?";
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
    public void deleteUser(int usersID) {
        String sql = "DELETE FROM Users WHERE usersID = ?";
        jdbcTemplate.update(sql, usersID);
    }

   

    @Override
    public List<Users> query(ParmQueryUsers parmQuery) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'query'");
    }
}
