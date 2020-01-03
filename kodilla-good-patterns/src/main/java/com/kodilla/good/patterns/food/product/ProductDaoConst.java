package com.kodilla.good.patterns.food.product;

import java.util.*;

public class ProductDaoConst extends ProductDaoCommon implements ProductDao {
    private final String[] productList;

    public ProductDaoConst(String[] productList) {
        super();
        this.productList = productList;
    }

    @Override
    public Map<Product, Integer> createProducts() {
        Map<Product, Integer> result = new HashMap<>();

        for (int i = 0; i < productList.length; i++) {
            AbstractMap.SimpleEntry<Product, Integer> entry = createProduct(productList[i]);
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
