package com.kodilla.rps.game;

import com.kodilla.rps.logic.Gamer;
import com.kodilla.rps.round.Result;
import com.kodilla.rps.round.Round;
import com.kodilla.rps.inteface.UserInterface;

public class Game {
    private Settings settings;
    private Statistics statistics;

    public Game() {
        settings = new Settings(Languages.ENG, "No Name", 0);
        statistics = new Statistics();
    }

    public void startGame() {
        settings.setLanguage(UserInterface.getLanguage());
        settings.setName(UserInterface.getName(settings.getLanguage()));
        settings.setMaxRoundToEnd(UserInterface.getMaxRound(settings.getLanguage()));

        System.out.println(settings.printGameSettings());
        System.out.println(settings.getLanguage().getGameInformation());

        run();
    }

    private void run() {
        boolean end = false;

        while(!end) {
            Elements gamerMove = new Gamer().getMove(settings.getLanguage());
            if (gamerMove == Elements.EXIT) {
                end = UserInterface.askForExit(settings.getLanguage());
            } else if (gamerMove == Elements.NEW_GAME) {
                end = startNewGame();
            } else {
                end = startNewRound(gamerMove);
            }
        }
    }

    private boolean startNewRound(Elements gamerMove) {

        Result result = new Round(settings).run(gamerMove);
        updateStatistics(result);

        return checkForEndGame();
    }

    private boolean checkForEndGame() {

        if (Math.abs(statistics.getComputerWinCounter() - statistics.getGamerWinCounter()) >= settings.getMaxRoundToEnd()) {
            return startNewGame();
        }

        return false;
    }

    private void updateStatistics(Result result) {
        statistics.setRoundCounter(statistics.getRoundCounter() + 1);
        if (result == Result.EQUAL) {
            statistics.setEqualCounter(statistics.getEqualCounter() + 1);
            statistics.setComputerWinCounter(statistics.getComputerWinCounter() + 1);
            statistics.setGamerWinCounter(statistics.getGamerWinCounter() + 1);
        } else if (result == Result.WINNER) {
            statistics.setGamerWinCounter(statistics.getGamerWinCounter() + 1);
        } else {
            statistics.setComputerWinCounter(statistics.getComputerWinCounter() + 1);
        }
    }

    private boolean startNewGame() {
        boolean newGame = !UserInterface.askForNewGame(settings.getLanguage());

        if (newGame) {
            statistics.resetStatistics();
        }

        return newGame;
    }
}
