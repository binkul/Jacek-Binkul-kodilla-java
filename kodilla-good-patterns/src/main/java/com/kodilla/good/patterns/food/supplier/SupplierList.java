package com.kodilla.good.patterns.food.supplier;

import com.kodilla.good.patterns.food.supplier.food.ExtraFoodShopProducts;
import com.kodilla.good.patterns.food.supplier.food.GlutenFreeShopProducts;
import com.kodilla.good.patterns.food.supplier.food.HealthyShopProducts;

public enum SupplierList {
    EXTRA_FOOD_SHOP("food/ExtraFoodShopProducts.txt", ExtraFoodShopProducts.PRODUCTS),
    GLUTEN_FREE_SHOP("food/GlutenFreeShopProducts.txt", GlutenFreeShopProducts.PRODUCTS),
    HEALTHY_SHOP("food/HealthyShopProducts.txt", HealthyShopProducts.PRODUCTS);

    private String path;
    private String[] products;

    SupplierList(String path, String[] products) {
        this.path = path;
        this.products = products;
    }

    public String getPath() {
        return path;
    }

    public String[] getProducts() {
        return products;
    }
}
