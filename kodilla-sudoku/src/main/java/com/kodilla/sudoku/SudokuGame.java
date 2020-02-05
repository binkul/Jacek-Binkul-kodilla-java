package com.kodilla.sudoku;

import com.kodilla.sudoku.user.Gameable;
import com.kodilla.sudoku.user.TemplateGame;
import com.kodilla.sudoku.user.TerminalGame;

public class SudokuGame {

    public static void main(String[] args) {
        while(true) {
            Gameable theGame = new TerminalGame();
            theGame.resolveSudoku();
        }
    }
}
