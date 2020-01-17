package com.kodilla.patterns.builder.bigmac.type;

public enum IngredientsType {
    SALAD("Salad"),
    ONION("Onion"),
    BACON("Bacon"),
    CUCUMBER("Cucumber"),
    CHILI_PEPPERS("Chili peppers"),
    CHAMPIGNON("Champignon"),
    SHRIMP("Shrimps"),
    CHEESE("Cheese");

    private final String name;

    IngredientsType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
