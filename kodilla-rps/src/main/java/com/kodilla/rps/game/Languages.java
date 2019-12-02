package com.kodilla.rps.game;

import com.kodilla.rps.constant.Captions;

public enum Languages {
    PL(     Captions.INPUT_NAME_PL,
            Captions.INPUT_MAX_WIN_PL,
            Captions.INPUT_CHEAT_LEVEL_PL,
            Captions.MAX_WIN_ERROR_PL,
            Captions.GAME_SETTING_PL,
            Captions.GAME_INFO_PL,
            Captions.ROUND_START_PL,
            Captions.END_THE_GAME_PL,
            Captions.START_THE_NEW_GAME_PL,
            Captions.GAMER_WIN_PL,
            Captions.COMPUTER_WIN_PL,
            Captions.ROUND_RESULTS_PL),
    ENG(    Captions.INPUT_NAME_EN,
            Captions.INPUT_MAX_WIN_EN,
            Captions.INPUT_CHEAT_LEVEL_EN,
            Captions.MAX_WIN_ERROR_EN,
            Captions.GAME_SETTING_EN,
            Captions.GAME_INFO_EN,
            Captions.ROUND_START_EN,
            Captions.END_THE_GAME_EN,
            Captions.START_THE_NEW_GAME_EN,
            Captions.GAMER_WIN_EN,
            Captions.COMPUTER_WIN_EN,
            Captions.ROUND_RESULTS_EN);

    private String inputName;
    private String inputMaxWin;
    private String inputCheatLevel;
    private String maxWinError;
    private String gameSettings;
    private String gameInformation;
    private String roundStart;
    private String endTheGame;
    private String startTheGame;
    private String gamerWinTheGame;
    private String computerWinTheGame;
    private String roundResults;

    Languages(String inputName, String inputMaxWin, String inputCheatLevel, String maxWinError, String gameSettings, String gameInformation,
              String roundStart, String endTheGame, String startTheGame, String gamerWinTheGame, String computerWinTheGame,
              String roundResults) {
        this.inputName = inputName;
        this.inputMaxWin = inputMaxWin;
        this.inputCheatLevel = inputCheatLevel;
        this.maxWinError = maxWinError;
        this.gameSettings = gameSettings;
        this.gameInformation = gameInformation;
        this.roundStart = roundStart;
        this.endTheGame = endTheGame;
        this.startTheGame = startTheGame;
        this.gamerWinTheGame = gamerWinTheGame;
        this.computerWinTheGame = computerWinTheGame;
        this.roundResults = roundResults;
    }

    public String getInputName() {
        return inputName;
    }

    public String getInputMaxWin() {
        return inputMaxWin;
    }

    public String getInputCheatLevel() {
        return inputCheatLevel;
    }

    public String getMaxWinError() {
        return maxWinError;
    }

    public String getGameSettings() {
        return gameSettings;
    }

    public String getGameInformation() {
        return gameInformation;
    }

    public String getRoundStart() {
        return roundStart;
    }

    public String getEndTheGame() {
        return endTheGame;
    }

    public String getStartTheGame() {
        return startTheGame;
    }

    public String getGamerWinTheGame() {
        return gamerWinTheGame;
    }

    public String getComputerWinTheGame() {
        return computerWinTheGame;
    }

    public String getRoundResults() {
        return roundResults;
    }
}
