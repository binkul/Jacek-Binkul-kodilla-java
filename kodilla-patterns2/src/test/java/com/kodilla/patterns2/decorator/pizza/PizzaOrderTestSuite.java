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
        theOrder = new IngredientDecorator(theOrder, Ingredient.CHEESE);
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        System.out.println("Cost: " + theOrder.getCost());
        // Then
        assertEquals(new BigDecimal(16), calculatedCost);
    }

    @Test
    public void testOneIngredientGetDescription() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new IngredientDecorator(theOrder, Ingredient.CHEESE);
        // When
        String description = theOrder.getDescription();
        System.out.println("Description: " + theOrder.getDescription());
        // Then
        assertEquals("Basic pizza set + Cheese", description);
    }

    @Test
    public void testThreeIngredientGetCost() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new IngredientDecorator(theOrder, Ingredient.CHEESE);
        theOrder = new IngredientDecorator(theOrder, Ingredient.BACON);
        theOrder = new IngredientDecorator(theOrder, Ingredient.CHILI_PEPPERS);
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        System.out.println("Cost: " + theOrder.getCost());
        // Then
        assertEquals(new BigDecimal(23), calculatedCost);
    }

    @Test
    public void testThreeIngredientGetDescription() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new IngredientDecorator(theOrder, Ingredient.CHEESE);
        theOrder = new IngredientDecorator(theOrder, Ingredient.BACON);
        theOrder = new IngredientDecorator(theOrder, Ingredient.CHILI_PEPPERS);
        // When
        String description = theOrder.getDescription();
        System.out.println("Description: " + theOrder.getDescription());
        // Then
        assertEquals("Basic pizza set + Cheese + Bacon + Chili peppers", description);
    }

    @Test
    public void testFewIngredientGetCost() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new IngredientDecorator(theOrder, Ingredient.CHEESE);
        theOrder = new IngredientDecorator(theOrder, Ingredient.BACON);
        theOrder = new IngredientDecorator(theOrder, Ingredient.ONION);
        theOrder = new IngredientDecorator(theOrder, Ingredient.CHAMPIGNON);
        theOrder = new IngredientDecorator(theOrder, Ingredient.SHRIMP);
        theOrder = new IngredientDecorator(theOrder, Ingredient.SHRIMP);
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        System.out.println("Cost: " + theOrder.getCost());
        // Then
        assertEquals(new BigDecimal(34), calculatedCost);
    }

    @Test
    public void testFewIngredientGetDescription() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new IngredientDecorator(theOrder, Ingredient.CHEESE);
        theOrder = new IngredientDecorator(theOrder, Ingredient.BACON);
        theOrder = new IngredientDecorator(theOrder, Ingredient.ONION);
        theOrder = new IngredientDecorator(theOrder, Ingredient.CHAMPIGNON);
        theOrder = new IngredientDecorator(theOrder, Ingredient.SHRIMP);
        theOrder = new IngredientDecorator(theOrder, Ingredient.SHRIMP);
        // When
        String description = theOrder.getDescription();
        System.out.println("Description: " + theOrder.getDescription());
        // Then
        assertEquals("Basic pizza set + Cheese + Bacon + Onion + Champignon + Shrimps + Shrimps", description);
    }
}
