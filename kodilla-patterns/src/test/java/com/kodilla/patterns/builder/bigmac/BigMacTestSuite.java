package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.builder.bigmac.type.Bun;
import com.kodilla.patterns.builder.bigmac.type.Ingredient;
import com.kodilla.patterns.builder.bigmac.type.Sauce;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BigMacTestSuite {
    @Before
    public void printBefore() {
        System.out.println("\nTest start.");
    }

    @After
    public void printAfter() {
        System.out.println("Test finished.");
    }

    @Test
    public void testBigMacNew() {
        //Given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .bun(Bun.SESAME_BUN)
                .burgers(2)
                .ingredient(Ingredient.CHEESE)
                .sauce(Sauce.THOUSAND_ISLAND)
                .ingredient(Ingredient.ONION)
                .ingredient(Ingredient.SALAD)
                .build();
        System.out.println(bigMac);

        //When
        int ingredientsCount = bigMac.getIngredientSize();

        //Then
        Assert.assertEquals(3, ingredientsCount);
        Assert.assertEquals(Bun.SESAME_BUN, bigMac.getBun());
        Assert.assertEquals(Sauce.THOUSAND_ISLAND, bigMac.getSauce());
    }

    @Test
    public void testBigMacBurgers() {
        //Given
        try {
            BigMac bigMac = new BigMac.BigMacBuilder()
                    .bun(Bun.SESAME_BUN)
                    .burgers(10)
                    .ingredient(Ingredient.CHEESE)
                    .sauce(Sauce.THOUSAND_ISLAND)
                    .ingredient(Ingredient.ONION)
                    .ingredient(Ingredient.SALAD)
                    .build();
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }

        //When
        //Then
    }

    @Test
    public void testBigMacNoBurgers() {
        //Given
        try {
            BigMac bigMac = new BigMac.BigMacBuilder()
                    .bun(Bun.SESAME_BUN)
                    .burgers(0)
                    .ingredient(Ingredient.CHEESE)
                    .sauce(Sauce.THOUSAND_ISLAND)
                    .ingredient(Ingredient.ONION)
                    .ingredient(Ingredient.SALAD)
                    .build();
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }

        //When
        //Then
    }

    @Test
    public void testBigMacNoIngredients() {
        //Given
        try {
            BigMac bigMac = new BigMac.BigMacBuilder()
                    .bun(Bun.SESAME_BUN)
                    .burgers(2)
                    .sauce(Sauce.THOUSAND_ISLAND)
                    .build();
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }

        //When
        //Then
    }
}
