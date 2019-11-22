package com.kodilla.rps.game;

public class Statistics {
    private int roundCounter;
    private int gamerWinCounter;
    private int computerWinCounter;
    private int equalCounter;

    public int getRoundCounter() {
        return roundCounter;
    }

    public int getGamerWinCounter() {
        return gamerWinCounter;
    }

    public int getComputerWinCounter() {
        return computerWinCounter;
    }

    public int getEqualCounter() {
        return equalCounter;
    }

    public void resetStatistics() {
        roundCounter = 0;
        gamerWinCounter = 0;
        computerWinCounter = 0;
        equalCounter = 0;
    }

    public void setRoundCounter(int roundCounter) {
        this.roundCounter = roundCounter;
    }

    public void setGamerWinCounter(int gamerWinCounter) {
        this.gamerWinCounter = gamerWinCounter;
    }

    public void setComputerWinCounter(int computerWinCounter) {
        this.computerWinCounter = computerWinCounter;
    }

    public void setEqualCounter(int equalCounter) {
        this.equalCounter = equalCounter;
    }
}
