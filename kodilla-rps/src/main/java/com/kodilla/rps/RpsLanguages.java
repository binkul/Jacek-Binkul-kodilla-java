package com.kodilla.rps;

public enum RpsLanguages {
    PL(     RpsCaptions.INPUT_NAME_PL,
            RpsCaptions.INPUT_MAX_WIN_PL,
            RpsCaptions.MAX_WIN_ERROR_PL,
            RpsCaptions.GAME_SETTING_PL,
            RpsCaptions.GAME_INFO_PL,
            RpsCaptions.ROUND_START_PL,
            RpsCaptions.END_THE_GAME_PL,
            RpsCaptions.START_THE_NEW_GAME_PL,
            RpsCaptions.GAMER_WIN_PL,
            RpsCaptions.COMPUTER_WIN_PL,
            RpsCaptions.ROUND_RESULTS_PL),
    ENG(    RpsCaptions.INPUT_NAME_EN,
            RpsCaptions.INPUT_MAX_WIN_EN,
            RpsCaptions.MAX_WIN_ERROR_EN,
            RpsCaptions.GAME_SETTING_EN,
            RpsCaptions.GAME_INFO_EN,
            RpsCaptions.ROUND_START_EN,
            RpsCaptions.END_THE_GAME_EN,
            RpsCaptions.START_THE_NEW_GAME_EN,
            RpsCaptions.GAMER_WIN_EN,
            RpsCaptions.COMPUTER_WIN_EN,
            RpsCaptions.ROUND_RESULTS_EN);

    private String inputName;
    private String inputMaxWin;
    private String maxWinError;
    private String gameSettings;
    private String gameInformation;
    private String roundStart;
    private String endTheGame;
    private String startTheGame;
    private String gamerWinTheGame;
    private String computerWinTheGame;
    private String roundResults;

    RpsLanguages(String inputName, String inputMaxWin, String maxWinError, String gameSetting, String gameInformation,
                 String roundStart, String endTheGame, String startTheGame, String gamerWinTheGame, String computerWinTheGame,
                 String roundResults) {
        this.inputName = inputName;
        this.inputMaxWin = inputMaxWin;
        this.maxWinError = maxWinError;
        this.gameSettings = gameSetting;
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
