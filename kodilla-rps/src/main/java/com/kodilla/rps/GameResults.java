package com.kodilla.rps;

public class GameResults {
    private int gameRoundCount;
    private int gamerScore;
    private int compScore;

    public GameResults() {
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

    public void printResult(RpsLanguages gameLanguage, int gamerResult, int compResult) {

    }
}
