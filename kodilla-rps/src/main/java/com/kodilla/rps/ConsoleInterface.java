package com.kodilla.rps;

import java.util.Scanner;

public class ConsoleInterface {
    private static final Scanner scanner = new Scanner(System.in);

    public static int setMaxRound(RpsLanguages rpsLanguages) {

        while(true) {
            printRoundInvitation(rpsLanguages);

            if(scanner.hasNextInt()) {
                int result = scanner.nextInt();
                scanner.nextLine();
                return result;
            } else {
                printRoundInputError(rpsLanguages);
                scanner.nextLine();
            }
        }
    }

    public static String setName(RpsLanguages rpsLanguages) {
        printNameInvitation(rpsLanguages);
        return scanner.nextLine();
    }

    public static RpsLanguages setLanguage() {
        int tmp = 0;

        while (tmp < 1 || tmp > 2) {
            printLanguageInvitation();
            if (scanner.hasNextInt()) {
                tmp = scanner.nextInt();
            } else {
                scanner.next();
            }
        }
        scanner.nextLine();
        return RpsLanguages.values()[tmp - 1];
    }

    public static char getKeyValue(RpsLanguages gameLanguage) {
        String answer = "0";

        printStartRoundInvitation(gameLanguage);
        answer = scanner.nextLine();
        return answer.length() > 0 ? answer.toLowerCase().charAt(0) : '0';
    }

    public static boolean askForGameEnd(RpsLanguages gameLanguage) {
        String answer;
        char tmp = '0';

        while (!(tmp == 'y' || tmp == 'n')) {
            printEndTheGameInvitation(gameLanguage);
            answer = scanner.nextLine();
            tmp = answer.length() > 0 ? answer.toLowerCase().charAt(0) : '0';
        }
        return tmp == 'y';
    }

    public static boolean askForNewGame(RpsLanguages gameLanguage) {
        String answer;
        char tmp = '0';

        while (!(tmp == 'y' || tmp == 'n')) {
            printNewGameInvitation(gameLanguage);
            answer = scanner.nextLine();
            tmp = answer.length() > 0 ? answer.toLowerCase().charAt(0) : '0';
        }
        return tmp == 'y';
    }

    private static void printLanguageInvitation() {
        System.out.println(RpsCaptions.LANGUAGE_SELECT);
    }

    private static void printNameInvitation(RpsLanguages rpsLanguages) {
        System.out.println(rpsLanguages.getInputName());
    }

    private static void printRoundInvitation(RpsLanguages rpsLanguages) {
        System.out.println(rpsLanguages.getInputMaxWin());
    }

    private static void printRoundInputError(RpsLanguages rpsLanguages) {
        System.out.println(rpsLanguages.getMaxWinError());
    }

    private static void printStartRoundInvitation(RpsLanguages rpsLanguages) {
        System.out.println(rpsLanguages.getRoundStart());
    }

    private static void printEndTheGameInvitation(RpsLanguages rpsLanguages) {
        System.out.println(rpsLanguages.getEndTheGame());
    }

    private static void printNewGameInvitation(RpsLanguages rpsLanguages) {
        System.out.println(rpsLanguages.getStartTheGame());
    }
}
