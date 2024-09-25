package com.my_app.my_app.dbG.Services;

import com.my_app.my_app.dbG.Parametri.ParamQuery;
import com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione.NodeCategoryProduct;
import com.my_app.my_app.dbG.Repository.Classsss.CategoryProductRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryProductSer {

    @Autowired
    private CategoryProductRep categoryProductRep;

    // Ricerca dinamica delle categorie prodotto
    public List<NodeCategoryProduct> findByDynamicQuery(ParamQuery paramQuery) {
        return categoryProductRep.findByDynamicQuery(paramQuery);
    }

    // Inserimento di un nuovo nodo categoria prodotto
    public void insertNodeCategoryProduct(NodeCategoryProduct categoryProduct) {
        categoryProductRep.insertNodeCategoryProduct(categoryProduct);
    }

    // Aggiornamento di un nodo categoria prodotto esistente
    public void updateNodeCategoryProduct(NodeCategoryProduct categoryProduct) {
        categoryProductRep.updateNodeCategoryProduct(categoryProduct);
    }

    // Eliminazione di un nodo categoria prodotto
    public void deleteNodeCategoryProduct(String categoryId) {
        categoryProductRep.deleteNodeCategoryProduct(categoryId);
    }
}
