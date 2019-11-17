package com.kodilla.rps;

public class GameSettings {
    private RpsLanguages language;
    private String name;
    private int maxRound;

    public GameSettings(RpsLanguages language, String name, int maxRoundToVin) {
        this.language = language;
        this.name = name;
        this.maxRound = maxRoundToVin;
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

    public void setLanguage(RpsLanguages language) {
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
        if (language == RpsLanguages.PL) {
            result = "Ustawienia gry {" +
                    "język = " + language +
                    ", imię gracza = '" + name + '\'' +
                    ", ilość rund do wygranej = " + maxRound +
                    "}\n";
        } else if (language == RpsLanguages.ENG) {
            result = "GameSettings {" +
                    "language = " + language +
                    ", name = '" + name + '\'' +
                    ", maxRound = " + maxRound +
                    "}\n";
        }

        return result;
    }
}
