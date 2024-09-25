package com.my_app.my_app.dbG.Repository.Interfacceeeee;

import com.my_app.my_app.dbG.Parametri.ParamQuery;
import com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione.NodeCategoryProduct;

import java.util.List;

public interface CategoryProductI {

    // Ricerca dinamica delle categorie prodotto
    List<NodeCategoryProduct> findByDynamicQuery(ParamQuery paramQuery);

    // Inserimento di un nuovo nodo categoria prodotto
    void insertNodeCategoryProduct(NodeCategoryProduct categoryProduct);

    // Aggiornamento di un nodo categoria prodotto esistente
    void updateNodeCategoryProduct(NodeCategoryProduct categoryProduct);

    // Eliminazione di un nodo categoria prodotto
    void deleteNodeCategoryProduct(String categoryId);
}
