package com.kodilla.rps.logic;

import com.kodilla.rps.rps.RpsRules;
import com.kodilla.rps.game.Elements;
import com.kodilla.rps.round.Result;

public class GameResolver {

    public static Result getWinner(Elements gamer, Elements computer) {

        if (gamer == computer) {
            return Result.EQUAL;
        } else if (RpsRules.getElement(gamer).getDefeatFirst() == computer || RpsRules.getElement(gamer).getDefeatSecond() == computer) {
            return Result.WINNER;
        } else {
            return Result.LOSE;
        }
    }
}
