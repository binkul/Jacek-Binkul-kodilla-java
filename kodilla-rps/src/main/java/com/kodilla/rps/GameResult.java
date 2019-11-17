package com.kodilla.rps;

public class GameResult {
    private int gameRoundCount;
    private int gamerScore;
    private int compScore;

    public GameResult() {
        resetGameResult();
    }

    public void resetGameResult() {
        gameRoundCount = 0;
        gamerScore = 0;
        compScore = 0;
    }

    public int getGameRoundCount() {
        return gameRoundCount;
    }

    public int getGamerScore() {
        return gamerScore;
    }

    public int getCompScore() {
        return compScore;
    }

    public void setGameRoundCount(int gameRoundCount) {
        this.gameRoundCount = gameRoundCount;
    }

    public void setGamerScore(int gamerScore) {
        this.gamerScore = gamerScore;
    }

    public void setCompScore(int compScore) {
        this.compScore = compScore;
    }

    public void printResult(GameLanguage gameLanguage, int gamerResult, int compResult) {
        if (gameLanguage == GameLanguage.PL) {
            System.out.format("Ilość ruchów = %d\n", gameRoundCount);
            System.out.format("Wynik rundy gracz:komputer = %d:%d\n", gamerResult, compResult);
            System.out.format("Wynik gry gracz:komputer = %d:%d\n", gamerScore, compScore);
        } else if (gameLanguage == GameLanguage.ENG) {
            System.out.format("Rounds count = %d\n", gameRoundCount);
            System.out.format("Round score gamer:computer = %d:%d\n", gamerResult, compResult);
            System.out.format("Game score gamer:computer = %d:%d\n", gamerScore, compScore);
        }
    }
}
