package com.kodilla.rps;

public enum RpsDependecies {
    ROCK(RpsElements.LIZARD_RPS, RpsElements.SCISSORS_RPS, RpsElements.PAPER_RPS, RpsElements.SPOCK_RPS),
    SCISSORS(RpsElements.PAPER_RPS, RpsElements.LIZARD_RPS, RpsElements.ROCK_RPS, RpsElements.SPOCK_RPS),
    PAPER(RpsElements.SPOCK_RPS, RpsElements.ROCK_RPS, RpsElements.SCISSORS_RPS, RpsElements.LIZARD_RPS),
    SPOCK(RpsElements.SCISSORS_RPS, RpsElements.ROCK_RPS, RpsElements.LIZARD_RPS, RpsElements.PAPER_RPS),
    LIZARD(RpsElements.PAPER_RPS, RpsElements.SPOCK_RPS, RpsElements.SCISSORS_RPS, RpsElements.ROCK_RPS);

    private RpsElements defeatFirst;
    private RpsElements defeatSecond;
    private RpsElements enemyFirst;
    private RpsElements enemySecond;

    RpsDependecies(RpsElements defeatFirst, RpsElements defeatSecond, RpsElements enemyFirst, RpsElements enemySecond) {
        this.defeatFirst = defeatFirst;
        this.defeatSecond = defeatSecond;
        this.enemyFirst = enemyFirst;
        this.enemySecond = enemySecond;
    }

    public RpsElements getDefeatFirst() {
        return defeatFirst;
    }

    public RpsElements getDefeatSecond() {
        return defeatSecond;
    }

    public RpsElements getEnemyFirst() {
        return enemyFirst;
    }

    public RpsElements getEnemySecond() {
        return enemySecond;
    }
}
