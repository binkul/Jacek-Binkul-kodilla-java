package com.kodilla.rps;

import java.util.Objects;

public class Round {
    private int gamerScore;
    private int computerScore;
    private RpsRules gamerRps;
    private RpsRules computerRps;

    public Round(int gamerScore, int computerScore, RpsRules gamerRps, RpsRules computerRps) {
        this.gamerScore = gamerScore;
        this.computerScore = computerScore;
        this.gamerRps = gamerRps;
        this.computerRps = computerRps;
    }

    public int getGamerScore() {
        return gamerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public RpsRules getGamerRps() {
        return gamerRps;
    }

    public RpsRules getComputerRps() {
        return computerRps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Round)) return false;
        Round round = (Round) o;
        return gamerScore == round.gamerScore &&
                computerScore == round.computerScore &&
                gamerRps == round.gamerRps &&
                computerRps == round.computerRps;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gamerScore, computerScore, gamerRps, computerRps);
    }
}
