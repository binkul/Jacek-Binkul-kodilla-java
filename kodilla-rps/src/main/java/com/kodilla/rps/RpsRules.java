package com.kodilla.rps;

public enum RpsRules {
    ROCK(RpsElements.ROCK_RPS, RpsElements.LIZARD_RPS, RpsElements.SCISSORS_RPS),
    SCISSORS(RpsElements.SCISSORS_RPS, RpsElements.PAPER_RPS, RpsElements.LIZARD_RPS),
    PAPER(RpsElements.PAPER_RPS, RpsElements.SPOCK_RPS, RpsElements.ROCK_RPS),
    SPOCK(RpsElements.SPOCK_RPS, RpsElements.SCISSORS_RPS, RpsElements.ROCK_RPS),
    LIZARD(RpsElements.LIZARD_RPS, RpsElements.PAPER_RPS, RpsElements.SPOCK_RPS);

    private RpsElements originalRps;
    private RpsElements defeatFirst;
    private RpsElements defeatSecond;

    RpsRules(RpsElements originalRps, RpsElements defeatFirst, RpsElements defeatSecond) {
        this.originalRps = originalRps;
        this.defeatFirst = defeatFirst;
        this.defeatSecond = defeatSecond;
    }

    public RpsElements getOriginalRps() {
        return originalRps;
    }

    public RpsElements getDefeatFirst() {
        return defeatFirst;
    }

    public RpsElements getDefeatSecond() {
        return defeatSecond;
    }
}
