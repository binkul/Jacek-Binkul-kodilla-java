package com.kodilla.patterns.builder.bigmac.type;

public enum Sauce {
    STANDARD("Standard sauce"),
    THOUSAND_ISLAND("Thousand island sauce"),
    BARBECUE("Barbecue sauce");

    private final String name;

    Sauce(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
