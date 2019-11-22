package com.kodilla.rps.game;

import java.util.stream.Stream;

public enum Elements {
    ROCK("1"),
    SCISSORS("2"),
    PAPER("3"),
    SPOCK("4"),
    LIZARD("5"),
    EXIT("x"),
    NEW_GAME("n");

    private String shortcut;

    Elements(String shortcut) {
        this.shortcut = shortcut;
    }

    public String getShortcut() {
        return shortcut;
    }

    public static Elements getElement(String element) {
        return Stream.of(Elements.values())
                .filter(n -> n.getShortcut().equals(element))
                .findFirst()
                .orElse(null);
    }

}
