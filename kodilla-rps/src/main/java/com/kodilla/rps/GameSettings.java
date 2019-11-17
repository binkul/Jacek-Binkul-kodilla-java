package com.kodilla.rps;

import java.util.Objects;

public final class GameSettings {
    private GameLanguage language;
    private String name;
    private int maxRound;

    public GameSettings(GameLanguage language, String name, int maxRoundToVin) {
        this.language = language;
        this.name = name;
        this.maxRound = maxRoundToVin;
    }

    public GameLanguage getLanguage() {
        return language;
    }

    public String getName() {
        return name;
    }

    public int getMaxRound() {
        return maxRound;
    }

    public void setLanguage(GameLanguage language) {
        this.language = language;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxRound(int maxRound) {
        this.maxRound = maxRound;
    }

    @Override
    public String toString() {
        String result = "";
        if (language == GameLanguage.PL) {
            result = "Ustawienia gry {" +
                    "język = " + language +
                    ", imię gracza = '" + name + '\'' +
                    ", ilość rund do wygranej = " + maxRound +
                    "}\n";
        } else if (language == GameLanguage.ENG) {
            result = "GameSettings {" +
                    "language = " + language +
                    ", name = '" + name + '\'' +
                    ", maxRound = " + maxRound +
                    "}\n";
        }

        return result;
    }
}
