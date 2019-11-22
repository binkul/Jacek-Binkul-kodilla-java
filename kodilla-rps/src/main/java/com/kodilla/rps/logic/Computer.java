package com.kodilla.rps.logic;

import com.kodilla.rps.game.Elements;
import com.kodilla.rps.game.Languages;

import java.util.Random;

public class Computer implements Movable {
    private static final Random random = new Random();

    @Override
    public Elements getMove(Languages languages) {
        return Elements.getElement(randomMove());
    }

    private String randomMove() {
        return String.valueOf(random.nextInt(5) + 1);
    }
}
