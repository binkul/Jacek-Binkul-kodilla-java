package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Round> rounds = new ArrayList<>();

    public void addRound(Round round) {
        rounds.add(round);
    }

    public boolean checkForEndGame(GameSettings gameSettings) {
        int gamerScore = sumGamerScore();
        int computerScore = sumComputerScore();
        boolean result = Math.abs((gamerScore - computerScore)) >= gameSettings.getMaxRound();

        if (result) {
            printGameResult(gamerScore, computerScore, gameSettings);
        }

        return result;
    }

    private int sumGamerScore() {

        return rounds.stream()
                .filter(n -> n.getGamerScore() > 0)
                .mapToInt(n -> n.getGamerScore())
                .sum();
    }

    private int sumComputerScore() {
        return rounds.stream()
                .filter(n -> n.getComputerScore() > 0)
                .mapToInt(n -> n.getComputerScore())
                .sum();
    }

    private void printGameResult(int gamerScore, int computerScore, GameSettings gameSettings) {
        RpsLanguages language = gameSettings.getLanguage();

        if (gamerScore > computerScore) {
            System.out.format(language.getGamerWinTheGame(), gameSettings.getName(), gamerScore, computerScore);
        } else {
            System.out.format(language.getComputerWinTheGame(), gamerScore, computerScore);
        }
    }
}
