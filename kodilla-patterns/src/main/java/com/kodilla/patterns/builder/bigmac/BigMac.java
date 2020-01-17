package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.builder.bigmac.type.Bun;
import com.kodilla.patterns.builder.bigmac.type.Ingredient;
import com.kodilla.patterns.builder.bigmac.type.Sauce;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BigMac {
    private final Bun bun;
    private final int burgers;
    private final Sauce sauce;
    private final List<Ingredient> ingredients;

    private BigMac(Bun bun, int burgers, Sauce sauce, List<Ingredient> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public static class BigMacBuilder {
        private Bun bun = Bun.NORMAL_BUN;
        private int burgers;
        private Sauce sauce = Sauce.BARBECUE;
        private List<Ingredient> ingredients = new ArrayList<>();

        public BigMacBuilder bun(Bun bun) {
            this.bun = bun;
            return this;
        }

        public BigMacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigMacBuilder sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigMacBuilder ingredient(Ingredient ingredient) {
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

    public Bun getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public int getIngredientSize() {
        return ingredients.size();
    }

    @Override
    public String toString() {
        return "BigMac - bun: " + bun.getName() +
                ", burgers: " + burgers +
                ", sauce: " + sauce.getName() +
                ", ingredients: " +
                ingredients.stream()
                        .map(Ingredient::getName)
                        .collect(Collectors.joining(", "));
    }
}
