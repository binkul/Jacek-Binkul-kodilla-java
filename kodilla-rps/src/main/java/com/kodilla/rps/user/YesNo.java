package com.kodilla.rps.user;

public enum YesNo {
    YES("y"),
    NO("n");

    private String shortcut;

    YesNo(String answer) {
        this.shortcut = answer;
    }

    public String getShortcut() {
        return shortcut;
    }
}
