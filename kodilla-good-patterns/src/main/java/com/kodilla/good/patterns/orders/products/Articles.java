package com.kodilla.good.patterns.orders.products;

import java.util.stream.Stream;

public enum Articles {
    GAME("Game", 2.65, StockStatus.PRESENT),
    BICYCLE("Bicycle", 265.90, StockStatus.PRESENT),
    LAPTOP("Laptop", 2000, StockStatus.OUT_OF_STOCK),
    COMPUTER("Computer", 0.0, StockStatus.NOT_AVAILABLE),
    SLIPPERS("Slippers", 12, StockStatus.PRESENT),
    TOOTHBRUSH("Toothbrush", 7.54, StockStatus.PRESENT);

    private String name;
    private double price;
    private StockStatus stockStatus;

    Articles(String name, double price, StockStatus stockStatus) {
        this.name = name;
        this.price = price;
        this.stockStatus = stockStatus;
    }

    public static Articles getArticle(String element) {
        return Stream.of(Articles.values())
                .filter(n -> n.getName().equals(element))
                .findFirst()
                .orElse(null);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public StockStatus getStockStatus() {
        return stockStatus;
    }
}
