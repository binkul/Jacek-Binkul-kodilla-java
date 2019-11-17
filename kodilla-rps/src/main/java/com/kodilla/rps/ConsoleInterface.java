package com.kodilla.rps;

import java.util.Scanner;

public class ConsoleInterface {
    private static final Scanner scanner = new Scanner(System.in);

    public GameSettings setGameSettings() {

        return null;
    }

    public int setMaxRound(RpsLanguages gameLanguage) {

        return 0;
    }

    public String setName(RpsLanguages gameLanguage) {

        return "";
    }

    public RpsLanguages setLanguage() {

        return null;
    }

    public char getKeyValue(RpsLanguages gameLanguage) {

        return 'x';
    }

    public boolean askForGameEnd(RpsLanguages gameLanguage) {

        return true;
    }

    public boolean askForNewGame(RpsLanguages gameLanguage) {

        return true;
    }

    private void printGameInvitation() {
        System.out.println("Select language:");
        System.out.println("[1] - Pl (polish)");
        System.out.println("[2] - Eng (english)");
    }

    private void printNameInvitation(RpsLanguages gameLanguage) {
        if (gameLanguage == RpsLanguages.PL) {
            System.out.println("\nPodaj imię gracza:");
        } else if (gameLanguage == RpsLanguages.ENG) {
            System.out.println("\nInput name:");
        }
    }

    private void printRoundInvitation(RpsLanguages gameLanguage) {
        if (gameLanguage == RpsLanguages.PL) {
            System.out.println("\nPodaj maksymalną ilość wygranych:");
        } else if (gameLanguage == RpsLanguages.ENG) {
            System.out.println("\nInput the maximum numbers of winnings :");
        }
    }

    private void printRoundInputError(RpsLanguages gameLanguage) {
        if (gameLanguage == RpsLanguages.PL) {
            System.out.println("Wartość musi być liczba całkowitą!");
        } else if (gameLanguage == RpsLanguages.ENG) {
            System.out.println("Input number have to be integer number!");
        }
    }

    private void printGameInformation(RpsLanguages gameLanguage) {
        System.out.println();
        if (gameLanguage == RpsLanguages.PL) {
            System.out.println("Informacje o grze:");
            System.out.println("Klawisz [1] - zagranie 'kamień'");
            System.out.println("Klawisz [2] - zagranie 'nożyce'");
            System.out.println("Klawisz [3] - zagranie 'papier'");
            System.out.println("Klawisz [4] - zagranie 'spock'");
            System.out.println("Klawisz [5] - zagranie 'jaszczurka'");
            System.out.println("Klawisz [x] - zakończenie gry");
            System.out.println("Klawisz [n] - uruchom od nowa (zakończ obecną rozgrywkę)");
        } else if (gameLanguage == RpsLanguages.ENG) {
            System.out.println("Game information:");
            System.out.println("Key [1] - play with 'rock'");
            System.out.println("Key [2] - play with 'scissors'");
            System.out.println("Key [3] - play with 'paper'");
            System.out.println("Key [4] - play with 'spock'");
            System.out.println("Key [5] - play with 'lizard'");
            System.out.println("Key [x] - end of the game");
            System.out.println("Key [n] - start again (finish current game)");
        }
    }
}
