package com.kodilla.rps.game;

public class Settings {
    private Languages language;
    private String name;
    private int maxRoundToEnd;

    public Settings(Languages language, String name, int maxRoundToEnd) {
        this.language = language;
        this.name = name;
        this.maxRoundToEnd = maxRoundToEnd;
    }

    public Languages getLanguage() {
        return language;
    }

    public String getName() {
        return name;
    }

    public int getMaxRoundToEnd() {
        return maxRoundToEnd;
    }

    public void setLanguage(Languages language) {
        this.language = language;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxRoundToEnd(int maxRoundToEnd) {
        this.maxRoundToEnd = maxRoundToEnd;
    }

    public String printGameSettings() {
        return String.format(language.getGameSettings(), language.name(), name, maxRoundToEnd);
    }
}
