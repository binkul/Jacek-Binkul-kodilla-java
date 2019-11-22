package com.kodilla.rps.round;

import com.kodilla.rps.logic.Computer;
import com.kodilla.rps.logic.GameResolver;
import com.kodilla.rps.game.Elements;
import com.kodilla.rps.game.Settings;

public class Round {
    private Settings settings;

    public Round(Settings settings) {
        this.settings = settings;
    }

    public Result run(Elements gamerMove) {
        Elements computerMove = new Computer().getMove(settings.getLanguage());

        return GameResolver.getWinner(gamerMove, computerMove);
    }
}
