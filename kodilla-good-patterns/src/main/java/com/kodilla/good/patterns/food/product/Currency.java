package com.kodilla.good.patterns.food.product;

public enum Currency {
    NONE("None"),
    PLN("PLN"),
    EUR("Eu"),
    USD("USD"),
    GBP("GBP");

    private String symbol;

    Currency(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
