package com.kodilla.rps;

import java.util.Scanner;

public class GameConsoleInterface {
    private static final Scanner scanner = new Scanner(System.in);

    public GameSettings gameSettings() {
        GameLanguage gameLanguage = setLanguage();
        String name = setName(gameLanguage);
        int maxRound = setMaxRound(gameLanguage);
        printGameInformation(gameLanguage);

        return new GameSettings(gameLanguage, name, maxRound);
    }

    public int setMaxRound(GameLanguage gameLanguage) {

        while(true) {
            printRoundInvitation(gameLanguage);

            if(scanner.hasNextInt()) {
                int result = scanner.nextInt();
                scanner.nextLine();
                return result;
            } else {
                printRoundInputError(gameLanguage);
                scanner.nextLine();
            }
        }
    }

    public String setName(GameLanguage gameLanguage) {
        printNameInvitation(gameLanguage);
        return scanner.nextLine();
    }

    public GameLanguage setLanguage() {
        int tmp = 0;

        while (tmp < 1 || tmp > 2) {
            printGameInvitation();
            if(scanner.hasNextInt()) {
                tmp = scanner.nextInt();
            } else {
                scanner.next();
            }
        }

        scanner.nextLine();
        return GameLanguage.values()[tmp - 1];
    }

    public char getKeyValue(GameLanguage gameLanguage) {

        return 'x';
    }

    public boolean askForGameEnd(GameLanguage gameLanguage) {

        return true;
    }

    public boolean askForNewGame(GameLanguage gameLanguage) {

        return true;
    }

    private void printGameInvitation() {
        System.out.println("Select language:");
        System.out.println("[1] - Pl (polish)");
        System.out.println("[2] - Eng (english)");
    }

    private void printNameInvitation(GameLanguage gameLanguage) {
        if (gameLanguage == GameLanguage.PL) {
            System.out.println("\nPodaj imię gracza:");
        } else if (gameLanguage == GameLanguage.ENG) {
            System.out.println("\nInput name:");
        }
    }

    private void printRoundInvitation(GameLanguage gameLanguage) {
        if (gameLanguage == GameLanguage.PL) {
            System.out.println("\nPodaj maksymalną ilość wygranych:");
        } else if (gameLanguage == GameLanguage.ENG) {
            System.out.println("\nInput the maximum numbers of winnings :");
        }
    }

    private void printRoundInputError(GameLanguage gameLanguage) {
        if (gameLanguage == GameLanguage.PL) {
            System.out.println("Wartość musi być liczba całkowitą!");
        } else if (gameLanguage == GameLanguage.ENG) {
            System.out.println("Input number have to be integer number!");
        }
    }

    private void printGameInformation(GameLanguage gameLanguage) {
        System.out.println();
        if (gameLanguage == GameLanguage.PL) {
            System.out.println("Informacje o grze:");
            System.out.println("Klawisz [1] - zagranie 'kamień'");
            System.out.println("Klawisz [2] - zagranie 'nożyce'");
            System.out.println("Klawisz [3] - zagranie 'papier'");
            System.out.println("Klawisz [4] - zagranie 'spock'");
            System.out.println("Klawisz [5] - zagranie 'jaszczurka'");
            System.out.println("Klawisz [x] - zakończenie gry");
            System.out.println("Klawisz [n] - uruchom od nowa (zakończ obecną rozgrywkę)");
        } else if (gameLanguage == GameLanguage.ENG) {
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
