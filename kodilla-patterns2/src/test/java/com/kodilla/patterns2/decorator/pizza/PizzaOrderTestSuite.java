package com.kodilla.patterns2.decorator.pizza;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {
    @Before
    public void beforeTest() {
        System.out.println("\nTest start ...");
    }

    @After
    public void afterTest() {
        System.out.println("Test finished ...\n");
    }

    @Test
    public void testBasicPizzaOrderGetCost() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        // When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        System.out.println("Cost: " + pizzaOrder.getCost());
        // Then
        assertEquals(new BigDecimal(15), calculatedCost);
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        // When
        String description = pizzaOrder.getDescription();
        System.out.println("Description: " + pizzaOrder.getDescription());
        // Then
        assertEquals("Basic pizza set", description);
    }

    @Test
    public void testOneIngredientGetCost() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        System.out.println("Cost: " + theOrder.getCost());
        // Then
        assertEquals(new BigDecimal(19), calculatedCost);
    }

    @Test
    public void testOneIngredientGetDescription() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        // When
        String description = theOrder.getDescription();
        System.out.println("Description: " + theOrder.getDescription());
        // Then
        assertEquals("Basic pizza set + extra cheese", description);
    }

    @Test
    public void testThreeIngredientGetCost() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ThickerBottomDecorator(theOrder);
        theOrder = new ShrimpDecorator(theOrder);
        theOrder = new ChiliPeppersDecorator(theOrder);
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        System.out.println("Cost: " + theOrder.getCost());
        // Then
        assertEquals(new BigDecimal(26), calculatedCost);
    }

    @Test
    public void testThreeIngredientGetDescription() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ThickerBottomDecorator(theOrder);
        theOrder = new ShrimpDecorator(theOrder);
        theOrder = new ChiliPeppersDecorator(theOrder);
        // When
        String description = theOrder.getDescription();
        System.out.println("Description: " + theOrder.getDescription());
        // Then
        assertEquals("Basic pizza set + thicker dough + shrimps + chili peppers", description);
    }

    @Test
    public void testFewIngredientGetCost() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ThickerBottomDecorator(theOrder);
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new OnionDecorator(theOrder);
        theOrder = new BaconDecorator(theOrder);
        theOrder = new MayonnaiseDecorator(theOrder);
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        System.out.println("Cost: " + theOrder.getCost());
        // Then
        assertEquals(new BigDecimal(38), calculatedCost);
    }

    @Test
    public void testFewIngredientGetDescription() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ThickerBottomDecorator(theOrder);
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new OnionDecorator(theOrder);
        theOrder = new BaconDecorator(theOrder);
        theOrder = new MayonnaiseDecorator(theOrder);
        // When
        String description = theOrder.getDescription();
        System.out.println("Description: " + theOrder.getDescription());
        // Then
        assertEquals("Basic pizza set + thicker dough + extra cheese + extra cheese + onion + bacon + mayonnaise", description);
    }
}
