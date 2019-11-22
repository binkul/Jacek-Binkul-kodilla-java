package com.kodilla.rps.inteface;

public enum Answer {
    YES("y"),
    NO("n");

    private String shortcut;

    Answer(String answer) {
        this.shortcut = answer;
    }

    public String getShortcut() {
        return shortcut;
    }
}
