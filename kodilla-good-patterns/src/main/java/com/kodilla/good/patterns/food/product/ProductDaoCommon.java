package com.kodilla.good.patterns.food.product;

import java.util.AbstractMap;
import java.util.stream.Stream;

public class ProductDaoCommon {

    AbstractMap.SimpleEntry<Product, Integer> createProduct(String line) {
        Product product;
        String[] values = line.split("\\|");

        try {
            product = new Product(values[1], Double.parseDouble(values[2]), convertToCurrency(values[3].toLowerCase()),
                     Double.parseDouble(values[4]), values[5], values[6]);
        } catch (IndexOutOfBoundsException e) {
            product = new Product(values[1], Double.parseDouble(values[2]), convertToCurrency(values[3].toLowerCase()),
                    Double.parseDouble(values[4]), values[5], " ");
        }

        return new AbstractMap.SimpleEntry<>(product, Integer.parseInt(values[0]));
    }

    private Currency convertToCurrency(String symbol) {
        return Stream.of(Currency.values())
                .filter(n -> n.name().toLowerCase().equals(symbol))
                .findFirst()
                .orElse(Currency.NONE);
    }
}
