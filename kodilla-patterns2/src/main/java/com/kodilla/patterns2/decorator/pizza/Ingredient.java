package com.kodilla.patterns2.decorator.pizza;

public enum Ingredient {
    SALAD("Salad", 2),
    ONION("Onion", 1),
    BACON("Bacon", 5),
    CUCUMBER("Cucumber", 3),
    CHILI_PEPPERS("Chili peppers", 2),
    CHAMPIGNON("Champignon", 6),
    SHRIMP("Shrimps", 3),
    CHEESE("Cheese", 1);

    private String name;
    private int price;

    Ingredient(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
