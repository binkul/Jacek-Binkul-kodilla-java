package com.kodilla.rps.game;

import com.kodilla.rps.logic.CheatLevels;

public class Settings {
    private Languages language;
    private String name;
    private int maxRoundToEnd;
    private CheatLevels cheatLevel;

    public Settings(Languages language, String name, int maxRoundToEnd, CheatLevels cheatLevel) {
        this.language = language;
        this.name = name;
        this.maxRoundToEnd = maxRoundToEnd;
        this.cheatLevel = cheatLevel;
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

    public CheatLevels getCheatLevel() {
        return cheatLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxRoundToEnd(int maxRoundToEnd) {
        this.maxRoundToEnd = maxRoundToEnd;
    }

    public void setCheatLevel(CheatLevels cheatLevel) {
        this.cheatLevel = cheatLevel;
    }

    @Override
    public String toString() {
        return String.format(language.getGameSettings(), language.name(), name, maxRoundToEnd);
    }
}
