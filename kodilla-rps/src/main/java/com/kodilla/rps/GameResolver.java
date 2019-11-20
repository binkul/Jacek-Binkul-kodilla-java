package com.kodilla.rps;

import java.util.Random;

public class GameResolver {
    private static final Random random = new Random();

    public static Round getRound(char keyValue) {
        RpsRules gamerRps = RpsRules.values()[keyValue - '1'];
        RpsRules computerRps = RpsRules.values()[getComputerRps()];
        int gamerWin = checkGamerWin(gamerRps, computerRps);

        if (gamerWin == -1) {
            return new Round(0, 1, gamerRps, computerRps);
        } else if (gamerWin == 1) {
            return new Round(1, 0, gamerRps, computerRps);
        } else {
            return new Round(1, 1, gamerRps, computerRps);
        }
    }

    private static int checkGamerWin(RpsRules gamer, RpsRules computer) {
        RpsElements gamerRps = gamer.getOriginalRps();

        /*
        -1 - gamer lost, computer win
        0 - game draw
        1 - gamer win, computer lost
         */
        if (gamer == computer) {
            return 0;
        } else if ((gamer.getOriginalRps() == computer.getDefeatFirst()) || (gamer.getOriginalRps() == computer.getDefeatSecond())) {
            return -1;
        } else {
            return 1;
        }
    }

    private static int getComputerRps() {
        return random.nextInt(5);
    }
}
