package com.kodilla.rps;

public class RpsRunner {
    public static void main(String[] args) {
        boolean end = false;
        char keyValue;
        GameLanguage language;

        GameConsoleInterface gameConsoleInterface = new GameConsoleInterface();
        GameResult gameResult = new GameResult();
        GameLogic gameLogic = new GameLogic();
        GameSettings gameSettings = gameConsoleInterface.gameSettings();
        language = gameSettings.getLanguage();
        System.out.println(gameSettings);

        while(!end) {
            keyValue = gameConsoleInterface.getKeyValue(language);
            if (keyValue >= '1' && keyValue <= '5') {
                end = gameLogic.computerMove(gameResult, gameConsoleInterface);
            } else if (keyValue == 'x') {
                end = gameConsoleInterface.askForGameEnd(language);
            } else if (keyValue == 'n') {
                if (gameConsoleInterface.askForNewGame(language)) {
                    language = gameConsoleInterface.setLanguage();
                    gameSettings.setLanguage(language);
                    gameSettings.setName(gameConsoleInterface.setName(language));
                    gameSettings.setMaxRound(gameConsoleInterface.setMaxRound(language));
                    gameResult.resetGameResult();
                }
            }
        }
    }
}
