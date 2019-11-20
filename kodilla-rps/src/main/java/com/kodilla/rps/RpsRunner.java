package com.kodilla.rps;

public class RpsRunner {
    public static void main(String[] args) {
        boolean end = false;
        char keyValue;

        Game game = new Game();
        System.out.println(game.printGameSettings());
        System.out.println(game.getLanguage().getGameInformation());

        while(!end) {
            keyValue = ConsoleInterface.getKeyValue(game.getLanguage());
            if (keyValue >= '1' && keyValue <= '5') {
                end = game.runGame(keyValue);
            } else if (keyValue == 'x') {
                end = ConsoleInterface.askForGameEnd(game.getLanguage());
            } else if (keyValue == 'n') {
                end = game.startTheNewGame();
            }
        }
    }
}
