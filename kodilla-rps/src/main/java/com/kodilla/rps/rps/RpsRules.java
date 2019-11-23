package com.kodilla.rps.rps;

import java.util.stream.Stream;

public enum RpsRules {
    ROCK(RpsElements.ROCK, RpsElements.LIZARD, RpsElements.SCISSORS, "Kamień", "Rock"),
    SCISSORS(RpsElements.SCISSORS, RpsElements.PAPER, RpsElements.LIZARD, "Nożyce", "Scissors"),
    PAPER(RpsElements.PAPER, RpsElements.ROCK, RpsElements.SPOCK, "Papier", "Paper"),
    SPOCK(RpsElements.SPOCK, RpsElements.SCISSORS, RpsElements.ROCK, "Spock", "Spock"),
    LIZARD(RpsElements.LIZARD, RpsElements.PAPER, RpsElements.SPOCK, "Jaszczurka", "Jaszczurka");

    private RpsElements originalRps;
    private RpsElements defeatFirst;
    private RpsElements defeatSecond;
    private String namePl;
    private String nameEn;

    RpsRules(RpsElements originalRps, RpsElements defeatFirst, RpsElements defeatSecond, String namePl, String nameEn) {
        this.originalRps = originalRps;
        this.defeatFirst = defeatFirst;
        this.defeatSecond = defeatSecond;
        this.namePl = namePl;
        this.nameEn = nameEn;
    }

    public RpsElements getDefeatFirst() {
        return defeatFirst;
    }

    public RpsElements getDefeatSecond() {
        return defeatSecond;
    }

    public String getNamePl() {
        return namePl;
    }

    public String getNameEn() {
        return nameEn;
    }

    public static RpsRules getElement(RpsElements elements) {
        return Stream.of(RpsRules.values())
                .filter(n -> n.originalRps.equals(elements))
                .findFirst()
                .orElse(null);
    }
}
