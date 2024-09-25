package com.my_app.my_app.dbG.Services;

import com.my_app.my_app.dbG.Parametri.ParamQuery;
import com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione.NodeProduct;
import com.my_app.my_app.dbG.Repository.Classsss.ProductRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSer {

    @Autowired
    private ProductRep productRep;

    // Ricerca dinamica dei prodotti
    public List<NodeProduct> findByDynamicQuery(ParamQuery paramQuery) {
        return productRep.findByDynamicQuery(paramQuery);
    }

    // Inserimento di un nuovo nodo prodotto
    public void insertNodeProduct(NodeProduct product) {
        productRep.insertNodeProduct(product);
    }

    // Aggiornamento di un nodo prodotto esistente
    public void updateNodeProduct(NodeProduct product) {
        productRep.updateNodeProduct(product);
    }

    // Eliminazione di un nodo prodotto
    public void deleteNodeProduct(String productId) {
        productRep.deleteNodeProduct(productId);
    }
}
