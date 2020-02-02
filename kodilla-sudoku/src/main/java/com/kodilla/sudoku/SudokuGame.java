package com.kodilla.sudoku;

import com.kodilla.sudoku.user.Gameable;
import com.kodilla.sudoku.user.TemplateGame;
import com.kodilla.sudoku.user.TerminalGame;

public class SudokuGame {

    public static void main(String[] args) {
        boolean gameFinished = false;

        while(!gameFinished) {
            Gameable theGame = new TerminalGame();
            gameFinished = theGame.resolveSudoku();
        }
    }
}
