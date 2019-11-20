package com.kodilla.rps;

public enum RpsElements {
    ROCK_RPS("Kamień", "Rock"),
    SCISSORS_RPS("Nożyce", "Scissors"),
    PAPER_RPS("Papier", "Paper"),
    SPOCK_RPS("Spock", "Spock"),
    LIZARD_RPS("Jaszczurka", "Lizard");

    private String namePl;
    private String nameEng;

    RpsElements(String namePl, String nameEng) {
        this.namePl = namePl;
        this.nameEng = nameEng;
    }

    public String getNamePl() {
        return namePl;
    }

    public String getNameEng() {
        return nameEng;
    }
}
