package com.kodilla.good.patterns.food.supplier;

import com.kodilla.good.patterns.food.product.Product;

import java.util.Map;
import java.util.Optional;

public class FoodCommon {

    Optional<Product> getArticleByName(String name, Map<Product, Integer> products) {
        return products.keySet().stream()
                .filter(product -> product.getName().equals(name))
                .findFirst();
    }

    Integer getAmountByName(String name, Map<Product, Integer> products) {
        return products.entrySet().stream()
                .filter(e -> e.getKey().getName().equals(name))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(0);
    }

    Optional<Map.Entry<Product, Integer>> getArticlesByBonus(double bonus, Map<Product, Integer> products) {
        return products.entrySet().stream()
                .filter(e -> e.getKey().getBonus() >= bonus)
                .findFirst();
    }

    void printArticles(Map<Product, Integer> products) {
        products.keySet().forEach(System.out::println);
    }
}
