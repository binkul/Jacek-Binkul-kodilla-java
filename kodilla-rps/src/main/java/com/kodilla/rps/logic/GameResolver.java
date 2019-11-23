package com.kodilla.rps.logic;

import com.kodilla.rps.round.Result;
import com.kodilla.rps.rps.RpsElements;
import com.kodilla.rps.rps.RpsRules;

public class GameResolver {

    public static Result getWinner(RpsElements gamer, RpsElements computer) {

        if (gamer == computer) {
            return Result.EQUAL;
        } else if (RpsRules.getElement(gamer).getDefeatFirst() == computer || RpsRules.getElement(gamer).getDefeatSecond() == computer) {
            return Result.WINNER;
        } else {
            return Result.LOSE;
        }
    }
}
