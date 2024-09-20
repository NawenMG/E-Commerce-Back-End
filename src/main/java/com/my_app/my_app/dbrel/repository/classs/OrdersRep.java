package com.my_app.my_app.dbrel.repository.classs;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.my_app.my_app.dbrel.model.Products;
import com.my_app.my_app.dbrel.parametri.ParamQuery;
import com.my_app.my_app.dbrel.parametri.ParmQueryProducts;
import com.my_app.my_app.dbrel.repository.interfacee.ProductsRepI;

@Repository
public class OrdersRep implements ProductsRepI {

    @Autowired
    private JdbcTemplate jdbcTemplate;

   
    //Query
    public List<Products> query(ParamQuery paramQuery) {
        StringBuilder sql = new StringBuilder("SELECT ");

        // Aggiungi DISTINCT se necessario
        if (paramQuery.isDistinct()) {
            sql.append("DISTINCT ");
        }

        // Aggiungi ALL se specificato
        if (paramQuery.isAll()) {
            sql.append("ALL ");
        }

        // Aggiungi i campi da selezionare (default a '*')
        sql.append("* FROM Orders ");

        // Aggiungi condizioni WHERE
        if (paramQuery.getCondizioneWhere().isPresent()) {
            sql.append("WHERE ").append(paramQuery.getCondizioneWhere().get()).append(" ");
        }
        if (paramQuery.getValoriWhere().isPresent()) {
            sql.append(paramQuery.getValoriWhere().get()).append(" ");
        }
        if (paramQuery.getBoleani().isPresent()) {
            sql.append(paramQuery.getBoleani().get()).append(" ");
        }

        // Gestisci l'ordinamento
        if (paramQuery.isOrderBy()) {
            sql.append("ORDER BY ").append(paramQuery.isOrderBy() ? "DESC " : "ASC ");
        }

        // Aggiungi TOP se specificato
        if (paramQuery.getTop() != null) {
            sql.insert(6, "TOP " + paramQuery.getTop() + " ");
        }

        // Aggiungi le funzioni di aggregazione se richieste
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

        // Aggiungi LIKE se presente
        if (paramQuery.getLike().isPresent() && paramQuery.getCondizioneWhere().isPresent()) {
            sql.append("LIKE ").append(paramQuery.getLike().get()).append(" ");
        }

        // Restituisci i risultati
        return jdbcTemplate.query(sql.toString(), (rs, rowNum) -> new Products(
            rs.getInt("ProductID"),
            rs.getString("Nome"),
            rs.getDouble("Prezzo"),
            rs.getString("Descrizione"),
            rs.getString("Immagine"),
            rs.getInt("AmountAvailable"),
            rs.getString("Categoria"),
            rs.getDate("DataDiInserimento").toLocalDate()
        ));
    }
    //Per implementare il faker
    public void saveAll(List<Products> products) {
        String sql = "INSERT INTO Prodotti (Nome, Prezzo, Descrizione, Immagine, AmountAvailable, Categoria, DataDiInserimento) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        for (Products product : products) {
            jdbcTemplate.update(sql, 
                product.getNome(), 
                product.getPrezzo(), 
                product.getDescrizione(), 
                product.getImmagine(), 
                product.getAmountAvailable(), 
                product.getCategoria(), 
                product.getDataDiInserimento()
            );
        }
    }

    //Insert
    public void insertProduct(Products product) {
        String sql = "INSERT INTO products (productId, nome, prezzo, descrizione, immagine, amountAvailable, categoria, dataDiInserimento) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, 
            product.getProductId(), 
            product.getNome(), 
            product.getPrezzo(), 
            product.getDescrizione(), 
            product.getImmagine(), 
            product.getAmountAvailable(), 
            product.getCategoria(), 
            product.getDataDiInserimento());
    }

    //Update
    public void updateProduct(Products product) {
        String sql = "UPDATE products SET nome = ?, prezzo = ?, descrizione = ?, immagine = ?, amountAvailable = ?, categoria = ?, dataDiInserimento = ? " +
                     "WHERE productId = ?";
        jdbcTemplate.update(sql, 
            product.getNome(), 
            product.getPrezzo(), 
            product.getDescrizione(), 
            product.getImmagine(), 
            product.getAmountAvailable(), 
            product.getCategoria(), 
            product.getDataDiInserimento(), 
            product.getProductId());
    }

    //Delete
    public void deleteProduct(int productId) {
        String sql = "DELETE FROM products WHERE productId = ?";
        jdbcTemplate.update(sql, productId);
    }
    @Override
    public List<Products> query(ParmQueryProducts parmQuery) {
        throw new UnsupportedOperationException("Unimplemented method 'query'");
    }
    
}


