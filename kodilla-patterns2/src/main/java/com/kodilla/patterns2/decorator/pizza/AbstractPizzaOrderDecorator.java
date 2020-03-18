package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class AbstractPizzaOrderDecorator implements PizzaOrder {
    private final PizzaOrder pizzaOrder;
    private final Ingredient ingredient;

    protected AbstractPizzaOrderDecorator(PizzaOrder pizzaOrder, Ingredient ingredient) {
        this.pizzaOrder = pizzaOrder;
        this.ingredient = ingredient;
    }

    @Override
    public BigDecimal getCost() {
        return pizzaOrder.getCost();
    }

    @Override
    public String getDescription() {
        return pizzaOrder.getDescription();
    }

    public int getIngredientPrice() {
        return ingredient.getPrice();
    }

    public String getIngredientName() {
        return ingredient.getName();
    }
}
