package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.builder.bigmac.type.BunType;
import com.kodilla.patterns.builder.bigmac.type.IngredientsType;
import com.kodilla.patterns.builder.bigmac.type.SauceType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BigMac {
    private final BunType bun;
    private final int burgers;
    private final SauceType sauce;
    private final List<IngredientsType> ingredients;

    private BigMac(BunType bun, int burgers, SauceType sauce, List<IngredientsType> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public static class BigMacBuilder {
        private BunType bun = BunType.NORMAL_BUN;
        private int burgers;
        private SauceType sauce = SauceType.BARBECUE;
        private List<IngredientsType> ingredients = new ArrayList<>();

        public BigMacBuilder bun(BunType bun) {
            this.bun = bun;
            return this;
        }

        public BigMacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigMacBuilder sauce(SauceType sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigMacBuilder ingredients(IngredientsType ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public BigMac build() {
            if (burgers <= 0) {
                throw new IllegalStateException("Minimum number of burgers should be 1");
            } else if (burgers >= 10) {
                throw new IllegalStateException("It is impossible to put more than 10 burgers in one bun !!!");
            }

            if (ingredients.size() == 0) {
                throw new IllegalStateException("We don't sell BigMac without any ingredient !");
            }

            return new BigMac(bun, burgers, sauce, ingredients);
        }
    }

    public BunType getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public SauceType getSauce() {
        return sauce;
    }

    public List<IngredientsType> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "BigMac - bun: " + bun.getName() +
                ", burgers: " + burgers +
                ", sauce: " + sauce.getName() +
                ", ingredients: " +
                ingredients.stream()
                        .map(IngredientsType::getName)
                        .collect(Collectors.joining(", "));
    }
}
