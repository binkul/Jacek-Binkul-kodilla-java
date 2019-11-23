package com.kodilla.rps.rps;

import java.util.stream.Stream;

public enum RpsElements {
    ROCK("1"),
    SCISSORS("2"),
    PAPER("3"),
    SPOCK("4"),
    LIZARD("5"),
    EXIT("x"),
    NEW_GAME("n");

    private String shortcut;

    RpsElements(String shortcut) {
        this.shortcut = shortcut;
    }

    public String getShortcut() {
        return shortcut;
    }

    public static RpsElements getElement(String element) {
        return Stream.of(RpsElements.values())
                .filter(n -> n.getShortcut().equals(element))
                .findFirst()
                .orElse(null);
    }
}
