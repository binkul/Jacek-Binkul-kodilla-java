package com.kodilla.sudoku.user;

public interface Gameable {
    String SUDOKU = "sudoku";
    String EXIT = "exit";

    boolean resolveSudoku();
    void startGame();
}
