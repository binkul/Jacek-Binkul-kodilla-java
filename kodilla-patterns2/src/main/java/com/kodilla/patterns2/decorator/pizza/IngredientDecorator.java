package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class IngredientDecorator extends AbstractPizzaOrderDecorator {
    public IngredientDecorator(PizzaOrder pizzaOrder, Ingredient ingredient) {
        super(pizzaOrder, ingredient);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(super.getIngredientPrice()));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + " + super.getIngredientName();
    }

}
