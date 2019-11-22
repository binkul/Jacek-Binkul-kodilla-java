package com.kodilla.rps.rps;

import com.kodilla.rps.game.Elements;

import java.util.stream.Stream;

public enum RpsRules {
    ROCK(Elements.ROCK, Elements.LIZARD, Elements.SCISSORS, "Kamień", "Rock"),
    SCISSORS(Elements.SCISSORS, Elements.PAPER, Elements.LIZARD, "Nożyce", "Scissors"),
    PAPER(Elements.PAPER, Elements.ROCK, Elements.SPOCK, "Papier", "Paper"),
    SPOCK(Elements.SPOCK, Elements.SCISSORS, Elements.ROCK, "Spock", "Spock"),
    LIZARD(Elements.LIZARD, Elements.PAPER, Elements.SPOCK, "Jaszczurka", "Jaszczurka");

    private Elements originalRps;
    private Elements defeatFirst;
    private Elements defeatSecond;
    private String namePl;
    private String nameEn;

    RpsRules(Elements originalRps, Elements defeatFirst, Elements defeatSecond, String namePl, String nameEn) {
        this.originalRps = originalRps;
        this.defeatFirst = defeatFirst;
        this.defeatSecond = defeatSecond;
        this.namePl = namePl;
        this.nameEn = nameEn;
    }

    public Elements getOriginalRps() {
        return originalRps;
    }

    public Elements getDefeatFirst() {
        return defeatFirst;
    }

    public Elements getDefeatSecond() {
        return defeatSecond;
    }

    public String getNamePl() {
        return namePl;
    }

    public String getNameEn() {
        return nameEn;
    }

    public static RpsRules getElement(Elements elements) {
        return Stream.of(RpsRules.values())
                .filter(n -> n.originalRps.equals(elements))
                .findFirst()
                .orElse(null);
    }
}
