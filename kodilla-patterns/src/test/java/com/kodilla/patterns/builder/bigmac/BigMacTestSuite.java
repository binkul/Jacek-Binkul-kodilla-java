package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.builder.bigmac.type.BunType;
import com.kodilla.patterns.builder.bigmac.type.IngredientsType;
import com.kodilla.patterns.builder.bigmac.type.SauceType;
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
                .bun(BunType.SESAME_BUN)
                .burgers(2)
                .ingredients(IngredientsType.CHEESE)
                .sauce(SauceType.THOUSAND_ISLAND)
                .ingredients(IngredientsType.ONION)
                .ingredients(IngredientsType.SALAD)
                .build();
        System.out.println(bigMac);

        //When
        int ingredientsCount = bigMac.getIngredients().size();

        //Then
        Assert.assertEquals(3, ingredientsCount);
        Assert.assertEquals(BunType.SESAME_BUN, bigMac.getBun());
        Assert.assertEquals(SauceType.THOUSAND_ISLAND, bigMac.getSauce());
    }

    @Test
    public void testBigMacBurgers() {
        //Given
        try {
            BigMac bigMac = new BigMac.BigMacBuilder()
                    .bun(BunType.SESAME_BUN)
                    .burgers(10)
                    .ingredients(IngredientsType.CHEESE)
                    .sauce(SauceType.THOUSAND_ISLAND)
                    .ingredients(IngredientsType.ONION)
                    .ingredients(IngredientsType.SALAD)
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
                    .bun(BunType.SESAME_BUN)
                    .burgers(0)
                    .ingredients(IngredientsType.CHEESE)
                    .sauce(SauceType.THOUSAND_ISLAND)
                    .ingredients(IngredientsType.ONION)
                    .ingredients(IngredientsType.SALAD)
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
                    .bun(BunType.SESAME_BUN)
                    .burgers(2)
                    .sauce(SauceType.THOUSAND_ISLAND)
                    .build();
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }

        //When
        //Then
    }
}
