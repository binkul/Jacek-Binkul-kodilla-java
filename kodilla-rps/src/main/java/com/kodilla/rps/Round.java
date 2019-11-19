package com.kodilla.rps;

import java.util.Objects;

public class Round {
    private int gamerScore;
    private int computerScore;

    public Round(int gamerScore, int computerScore) {
        this.gamerScore = gamerScore;
        this.computerScore = computerScore;
    }

    public int getGamerScore() {
        return gamerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Round)) return false;
        Round round = (Round) o;
        return gamerScore == round.gamerScore &&
                computerScore == round.computerScore;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gamerScore, computerScore);
    }
}
