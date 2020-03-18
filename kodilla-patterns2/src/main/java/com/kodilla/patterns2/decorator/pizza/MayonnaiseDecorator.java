package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class MayonnaiseDecorator extends AbstractPizzaOrderDecorator {
    protected MayonnaiseDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(1));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + mayonnaise";
    }
}
