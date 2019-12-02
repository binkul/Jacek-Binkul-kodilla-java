package com.kodilla.rps.round;

import com.kodilla.rps.game.Languages;
import com.kodilla.rps.game.Settings;
import com.kodilla.rps.game.Statistics;
import com.kodilla.rps.logic.ComputerMove;
import com.kodilla.rps.logic.GameResolver;
import com.kodilla.rps.rps.RpsElements;
import com.kodilla.rps.rps.RpsRules;

public class Round {
    private Settings settings;
    private Statistics statistics;

    public Round(Settings settings, Statistics statistics) {
        this.settings = settings;
        this.statistics = statistics;
    }

    public Result runRound(RpsElements gamerMove) {
        RpsElements computerMove = new ComputerMove(gamerMove, settings.getCheatLevel()).getMove();
        statistics.setLastGamerMove(gamerMove);
        statistics.setLastComputerMove(computerMove);
        return GameResolver.getWinner(gamerMove, computerMove);
    }

    @Override
    public String toString() {
        if (settings.getLanguage() == Languages.PL) {
            return String.format(settings.getLanguage().getRoundResults(),
                    statistics.getRoundCounter(),
                    settings.getName(),
                    RpsRules.getElement(statistics.getLastGamerMove()).getNamePl(),
                    RpsRules.getElement(statistics.getLastComputerMove()).getNamePl(),
                    statistics.getLastResult(),
                    statistics.getGamerWinCounter(),
                    statistics.getComputerWinCounter());
        } else if (settings.getLanguage() == Languages.ENG) {
            return String.format(settings.getLanguage().getRoundResults(),
                    statistics.getRoundCounter(),
                    settings.getName(),
                    RpsRules.getElement(statistics.getLastGamerMove()).getNameEn(),
                    RpsRules.getElement(statistics.getLastComputerMove()).getNameEn(),
                    statistics.getLastResult(),
                    statistics.getGamerWinCounter(),
                    statistics.getComputerWinCounter());
        }

        return "";
    }
}
