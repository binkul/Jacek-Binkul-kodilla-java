package com.kodilla.patterns.builder.bigmac.type;

public enum SauceType {
    STANDARD("Standard sauce"),
    THOUSAND_ISLAND("Thousand island sauce"),
    BARBECUE("Barbecue sauce");

    private final String name;

    SauceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
