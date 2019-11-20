package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;

public class Game extends GameSettings {
    private List<Round> rounds = new ArrayList<>();

    public  Game() {
        super();
    }

    public boolean runGame(char keyValue) {

        Round round = GameResolver.getRound(keyValue);
        addRound(round);
        if (checkForEndGame()) {
            return startTheNewGame();
        }
        return false;
    }

    private void addRound(Round round) {
        rounds.add(round);
        printRoundResult(round);
    }

    private boolean checkForEndGame() {
        int gamerScore = sumGamerScore();
        int computerScore = sumComputerScore();
        boolean result = Math.abs((gamerScore - computerScore)) >= getMaxRound();

        if (result) {
            printGameResult(gamerScore, computerScore);
        }

        return result;
    }

    public boolean startTheNewGame() {
        if (ConsoleInterface.askForNewGame(getLanguage())) {
            setMaxRound();
            rounds.clear();
            return false;
        } else {
            return true;
        }
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

    private void printGameResult(int gamerScore, int computerScore) {
        RpsLanguages language = getLanguage();

        if (gamerScore > computerScore) {
            System.out.format(language.getGamerWinTheGame(), getName(), gamerScore, computerScore);
        } else {
            System.out.format(language.getComputerWinTheGame(), gamerScore, computerScore);
        }
    }

    private void printRoundResult(Round round) {
        String result = "";

        if (getLanguage() == RpsLanguages.PL) {
            result = String.format(getLanguage().getRoundResults(),
                    getName(),
                    round.getGamerRps().getOriginalRps().getNamePl(),
                    round.getComputerRps().getOriginalRps().getNamePl(),
                    round.getGamerScore(),
                    round.getComputerScore(),
                    sumGamerScore(),
                    sumComputerScore());
        } else if (getLanguage() == RpsLanguages.ENG) {
            result = String.format(getLanguage().getRoundResults(),
                    getName(),
                    round.getGamerRps().getOriginalRps().getNameEng(),
                    round.getComputerRps().getOriginalRps().getNameEng(),
                    round.getGamerScore(),
                    round.getComputerScore(),
                    sumGamerScore(),
                    sumComputerScore());
        }

        System.out.println(result);
    }
}
