package com.my_app.my_app.dbG.Repository.Interfacceeeee;

import com.my_app.my_app.dbG.Parametri.ParamQuery;
import com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione.NodeProduct;

import java.util.List;

public interface ProductI {

    // Ricerca dinamica dei prodotti
    List<NodeProduct> findByDynamicQuery(ParamQuery paramQuery);

    // Inserimento di un nuovo nodo prodotto
    void insertNodeProduct(NodeProduct product);

    // Aggiornamento di un nodo prodotto esistente
    void updateNodeProduct(NodeProduct product);

    // Eliminazione di un nodo prodotto
    void deleteNodeProduct(String productId);
}
