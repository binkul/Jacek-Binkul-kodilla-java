package com.kodilla.rps.inteface;

import com.kodilla.rps.constant.Captions;
import com.kodilla.rps.game.Elements;
import com.kodilla.rps.game.Languages;

import java.util.Scanner;
import java.util.stream.Stream;

public class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);

    public static Languages getLanguage() {
        String inputText;

        while (true) {
            printLanguageInvitation();
            inputText = scanner.nextLine();
            if (inputText.equals("1")) {
                return Languages.PL;
            } else if (inputText.equals("2")) {
                return  Languages.ENG;
            }
        }
    }

    public static String getName(Languages languages) {
        printNameInvitation(languages);
        return scanner.nextLine();
    }

    public static int getMaxRound(Languages languages) {

        while(true) {
            printMaxRoundInvitation(languages);

            if(scanner.hasNextInt()) {
                int result = scanner.nextInt();
                scanner.nextLine();
                return result;
            } else {
                printRoundInputError(languages);
                scanner.nextLine();
            }
        }
    }

    public static Elements getKeyValue(Languages languages) {
        String keyValue;

        while (true) {
            printInputKeyValue(languages);
            keyValue = scanner.nextLine().toLowerCase();
            if(validKey(keyValue)) {
                return Elements.getElement(keyValue);
            }
        }
    }

    public static boolean askForExit(Languages languages) {
        String keyValue;

        while (true) {
            printExitInvitation(languages);
            keyValue = scanner.nextLine().toLowerCase();
            if (checkYesNo(keyValue)) {
                return keyValue.equals("y");
            }
        }
    }

    public static boolean askForNewGame(Languages languages) {
        String keyValue;

        while (true) {
            printNewGameInvitation(languages);
            keyValue = scanner.nextLine().toLowerCase();
            if (checkYesNo(keyValue)) {
                return keyValue.equals("y");
            }
        }
    }

    private static boolean checkYesNo(String keyValue) {
        return keyValue.equals(Answer.YES.getShortcut()) || keyValue.equals(Answer.NO.getShortcut());
    }

    private static boolean validKey(String keyValue) {
        return Stream.of(Elements.values())
                .anyMatch(n -> n.getShortcut().equals(keyValue));
    }

    private static void printLanguageInvitation() {
        System.out.println(Captions.LANGUAGE_SELECT);
    }

    private static void printNameInvitation(Languages language) {
        System.out.println(language.getInputName());
    }

    private static void printMaxRoundInvitation(Languages languages) {
        System.out.println(languages.getInputMaxWin());
    }

    private static void printRoundInputError(Languages languages) {
        System.out.println(languages.getMaxWinError());
    }

    private static void printInputKeyValue(Languages languages) {
        System.out.println(languages.getRoundStart());
    }

    private static void printExitInvitation(Languages languages) {
        System.out.println(languages.getEndTheGame());
    }

    private static void printNewGameInvitation(Languages languages) {
        System.out.println(languages.getStartTheGame());
    }
}
