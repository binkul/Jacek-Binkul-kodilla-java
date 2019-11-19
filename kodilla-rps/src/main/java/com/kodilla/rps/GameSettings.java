package com.kodilla.rps;

public class GameSettings {
    private RpsLanguages language = RpsLanguages.PL;
    private String name;
    private int maxRound;

    public GameSettings() {
        setLanguage();
        setName();
        setMaxRound();
    }

    public RpsLanguages getLanguage() {
        return language;
    }

    public String getName() {
        return name;
    }

    public int getMaxRound() {
        return maxRound;
    }

    public void setLanguage() {
        language = ConsoleInterface.setLanguage();
    }

    public void setName() {
        name = ConsoleInterface.setName(language);
    }

    public void setMaxRound() {
        maxRound = ConsoleInterface.setMaxRound(language);
    }

    @Override
    public String toString() {
        return String.format(language.getGameSettings(), language.name(), name, maxRound);
    }
}
