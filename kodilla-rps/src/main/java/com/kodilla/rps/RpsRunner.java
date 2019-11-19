package com.kodilla.rps;

public class RpsRunner {
    public static void main(String[] args) {
        boolean end = false;
        char keyValue;

        GameSettings gameSettings = new GameSettings();
        Game game = new Game();
        GameResolver gameResolver = new GameResolver();
        System.out.println(gameSettings);
        System.out.println(gameSettings.getLanguage().getGameInformation());

        while(!end) {
            keyValue = ConsoleInterface.getKeyValue(gameSettings.getLanguage());
            if (keyValue >= '1' && keyValue <= '5') {
                Round round = gameResolver.getRound(gameSettings, keyValue);
                game.addRound(round);
                if (game.checkForEndGame(gameSettings)) {

                }

            } else if (keyValue == 'x') {
                end = ConsoleInterface.askForGameEnd(gameSettings.getLanguage());

            } else if (keyValue == 'n') {
                if (ConsoleInterface.askForNewGame(gameSettings.getLanguage())) {
                    gameSettings.setMaxRound();
                    game = new Game();
                } else {
                    end = true;
                }
            }
        }
    }
}
