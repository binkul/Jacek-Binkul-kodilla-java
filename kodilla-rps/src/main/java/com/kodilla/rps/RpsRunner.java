package com.kodilla.rps;

public class RpsRunner {
    public static void main(String[] args) {
        boolean end = false;
        char keyValue;
        RpsLanguages language;

        ConsoleInterface consoleInterface = new ConsoleInterface();
        GameResults gameResults = new GameResults();
        GameLogic gameLogic = new GameLogic();
        GameSettings gameSettings = consoleInterface.setGameSettings();
        language = gameSettings.getLanguage();
        System.out.println(gameSettings);

        while(!end) {
            keyValue = consoleInterface.getKeyValue(language);
            if (keyValue >= '1' && keyValue <= '5') {
                end = gameLogic.computerMove(gameResults, consoleInterface);
            } else if (keyValue == 'x') {
                end = consoleInterface.askForGameEnd(language);
            } else if (keyValue == 'n') {
                if (consoleInterface.askForNewGame(language)) {

                }
            }
        }
    }
}
