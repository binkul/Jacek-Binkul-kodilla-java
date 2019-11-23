package com.kodilla.rps.game;

import com.kodilla.rps.rps.RpsElements;
import com.kodilla.rps.inteface.UserInterface;
import com.kodilla.rps.logic.CheatLevels;
import com.kodilla.rps.logic.GamerMove;
import com.kodilla.rps.round.Result;
import com.kodilla.rps.round.Round;

public class Game {
    private Settings settings;
    private Statistics statistics;

    public Game() {
        settings = new Settings(Languages.ENG, "No Name", 0, CheatLevels.RANDOM);
        statistics = new Statistics();
    }

    public void startGame() {
        settings.setLanguage(UserInterface.getLanguage());
        settings.setName(UserInterface.getName(settings.getLanguage()));
        settings.setMaxRoundToEnd(UserInterface.getMaxRound(settings.getLanguage()));
        settings.setCheatLevel(UserInterface.getCheatLevel(settings.getLanguage()));

        System.out.println(settings);
        System.out.println(settings.getLanguage().getGameInformation());

        run();
    }

    private void run() {
        boolean end = false;

        while(!end) {
            RpsElements gamerMove = new GamerMove(settings.getLanguage()).getMove();
            if (gamerMove == RpsElements.EXIT) {
                end = UserInterface.askForExit(settings.getLanguage());
            } else if (gamerMove == RpsElements.NEW_GAME) {
                end = startNewGame();
            } else {
                end = startNewRound(gamerMove);
            }
        }
    }

    private boolean startNewRound(RpsElements gamerMove) {
        Round round = new Round(settings, statistics);
        Result result = round.runRound(gamerMove);
        updateStatistics(result);
        System.out.println(round);

        return checkForGameEnd();
    }

    private boolean checkForGameEnd() {
        if (Math.abs(statistics.getComputerWinCounter() - statistics.getGamerWinCounter()) >= settings.getMaxRoundToEnd()) {
            System.out.println(this);
            return startNewGame();
        }

        return false;
    }

    private boolean startNewGame() {
        if (UserInterface.askForNewGame(settings.getLanguage())) {
            statistics.resetStatistics();
            return false;
        }

        return true;
    }

    private void updateStatistics(Result result) {
        statistics.setRoundCounter(statistics.getRoundCounter() + 1);
        if (result == Result.EQUAL) {
            statistics.setEqualCounter(statistics.getEqualCounter() + 1);
            statistics.setComputerWinCounter(statistics.getComputerWinCounter() + 1);
            statistics.setGamerWinCounter(statistics.getGamerWinCounter() + 1);
            statistics.setLastResult("1:1");
        } else if (result == Result.WINNER) {
            statistics.setGamerWinCounter(statistics.getGamerWinCounter() + 1);
            statistics.setLastResult("1:0");
        } else {
            statistics.setComputerWinCounter(statistics.getComputerWinCounter() + 1);
            statistics.setLastResult("0:1");
        }

    }

    @Override
    public String toString() {
        if (statistics.getGamerWinCounter() > statistics.getComputerWinCounter()) {
            return String.format(settings.getLanguage().getGamerWinTheGame(), settings.getName(),
                    statistics.getGamerWinCounter(), statistics.getComputerWinCounter());
        } else {
            return String.format(settings.getLanguage().getComputerWinTheGame(),
                    statistics.getGamerWinCounter(), statistics.getComputerWinCounter());
        }
    }
}
