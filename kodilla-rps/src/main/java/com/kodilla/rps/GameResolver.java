package com.kodilla.rps;

import java.util.Random;

public class GameResolver {
    private static final Random random = new Random();

    public Round getRound(GameSettings gameSettings, char keyValue) {

        return new Round(1, 0);
    }

    private int checkGamerWin(RpsRules gamer, RpsRules computer) {

        return 0;
    }
}
