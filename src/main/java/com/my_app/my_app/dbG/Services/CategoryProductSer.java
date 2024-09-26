package com.my_app.my_app.dbG.Services;

import com.my_app.my_app.dbG.Parametri.ParamQuery;
import com.my_app.my_app.dbG.Models.SistemaDiRaccomandazione.NodeCategoryProduct;
import com.my_app.my_app.dbG.Repository.Classsss.CategoryProductRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryProductSer {

    @Autowired
    private CategoryProductRep categoryProductRep;

    @Cacheable(value = {"caffeineCache", "redisCache"}, key = "#id")
    public List<NodeCategoryProduct> findByDynamicQuery(ParamQuery paramQuery) {
        return categoryProductRep.findByDynamicQuery(paramQuery);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void insertNodeCategoryProduct(NodeCategoryProduct categoryProduct) {
        categoryProductRep.insertNodeCategoryProduct(categoryProduct);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void updateNodeCategoryProduct(NodeCategoryProduct categoryProduct) {
        categoryProductRep.updateNodeCategoryProduct(categoryProduct);
    }

    @CacheEvict(value = {"caffeineCache", "redisCache"}, key = "#id")
    public void deleteNodeCategoryProduct(String categoryId) {
        categoryProductRep.deleteNodeCategoryProduct(categoryId);
    }
}
