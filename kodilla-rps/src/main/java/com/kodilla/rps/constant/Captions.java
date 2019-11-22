package com.kodilla.rps.constant;

public final class Captions {
    public final static String LANGUAGE_SELECT =    "Select language:\n" +
                                                    "[1] - Pl (polish)\n" +
                                                    "[2] - Eng (english)";

    public final static String INPUT_NAME_PL = "\nPodaj imię gracza:";
    public final static String INPUT_NAME_EN = "\nInput name:";

    public final static String INPUT_MAX_WIN_PL = "\nPodaj maksymalną ilość wygranych:";
    public final static String INPUT_MAX_WIN_EN = "\nInput the maximum numbers of winnings:";

    public final static String MAX_WIN_ERROR_PL = "Wartość musi być liczba całkowitą!";
    public final static String MAX_WIN_ERROR_EN = "Input number have to be integer number!";

    public final static String GAME_SETTING_PL = "\nUstawienia gry {język = %s, imię gracza = '%s', ilość rund do wygranej = %d}";
    public final static String GAME_SETTING_EN = "\nGame settings {language = %s, gamer name = '%s', rounds to win = %d}";

    public final static String GAME_INFO_PL =    "Informacje o grze:\n" +
            "Klawisz [1] - zagranie 'kamień'\n" +
            "Klawisz [2] - zagranie 'nożyce'\n" +
            "Klawisz [3] - zagranie 'papier'\n" +
            "Klawisz [4] - zagranie 'spock'\n" +
            "Klawisz [5] - zagranie 'jaszczurka'\n" +
            "Klawisz [x] - zakończenie gry\n" +
            "Klawisz [n] - uruchom od nowa (zakończ obecną rozgrywkę)\n";
    public final static String GAME_INFO_EN =    "Game information:\n" +
            "Key [1] - play with 'rock'\n" +
            "Key [2] - play with 'scissors'\n" +
            "Key [3] - play with 'paper'\n" +
            "Key [4] - play with 'spock'\n" +
            "Key [5] - play with 'lizard'\n" +
            "Key [x] - end of the game\n" +
            "Key [n] - start again (finish current game)\n";

    public final static String ROUND_START_PL = "Wciśnij klawisz [1]-[5] lub [x] lub [n]";
    public final static String ROUND_START_EN = "Select key [1]-[5] or [x] or [n]";

    public final static String END_THE_GAME_PL = "Czy zakończyć grę? [y]/[n]";
    public final static String END_THE_GAME_EN = "Do You want to end the game? [y]/[n]";

    public final static String START_THE_NEW_GAME_PL = "Czy rozpocząć nowa grę? [y]/[n]";
    public final static String START_THE_NEW_GAME_EN = "Do You want to start the new game? [y]/[n]";

    public final static String GAMER_WIN_PL = "Grę wygrał %s wynikiem %d:%d\n";
    public final static String GAMER_WIN_EN = "The winner is %s with the result %d:%d\n";

    public final static String COMPUTER_WIN_PL = "Grę wygrał komputer wynikiem %d:%d\n";
    public final static String COMPUTER_WIN_EN = "The winner is computer with the result %d:%d\n";

    public final static String ROUND_RESULTS_PL = "Wynik rozgrywki '%s':komputer {ruch: '%s':'%s' , wynik rundy: %d:%d, wynik gry: %d:%d}\n";
    public final static String ROUND_RESULTS_EN = "Result '%s':computer {move: '%s':'%s' , round results: %d:%d, game results: %d:%d}\n";
}
