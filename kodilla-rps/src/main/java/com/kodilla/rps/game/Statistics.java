package com.kodilla.rps.game;

import com.kodilla.rps.rps.RpsElements;

public class Statistics {
    private int roundCounter;
    private int gamerWinCounter;
    private int computerWinCounter;
    private int equalCounter;
    private String lastResult;
    private RpsElements lastGamerMove;
    private RpsElements lastComputerMove;

    public int getRoundCounter() {
        return roundCounter;
    }

    public int getGamerWinCounter() {
        return gamerWinCounter;
    }

    public int getComputerWinCounter() {
        return computerWinCounter;
    }

    int getEqualCounter() {
        return equalCounter;
    }

    void resetStatistics() {
        roundCounter = 0;
        gamerWinCounter = 0;
        computerWinCounter = 0;
        equalCounter = 0;
        lastComputerMove = null;
        lastGamerMove = null;
        lastResult = null;
    }

    void setRoundCounter(int roundCounter) {
        this.roundCounter = roundCounter;
    }

    public String getLastResult() {
        return lastResult;
    }

    public RpsElements getLastGamerMove() {
        return lastGamerMove;
    }

    public RpsElements getLastComputerMove() {
        return lastComputerMove;
    }

    void setGamerWinCounter(int gamerWinCounter) {
        this.gamerWinCounter = gamerWinCounter;
    }

    void setComputerWinCounter(int computerWinCounter) {
        this.computerWinCounter = computerWinCounter;
    }

    void setEqualCounter(int equalCounter) {
        this.equalCounter = equalCounter;
    }

    void setLastResult(String lastResult) {
        this.lastResult = lastResult;
    }

    public void setLastGamerMove(RpsElements lastGamerMove) {
        this.lastGamerMove = lastGamerMove;
    }

    public void setLastComputerMove(RpsElements lastComputerMove) {
        this.lastComputerMove = lastComputerMove;
    }
}
