package com.kodilla.sudoku.user;

import com.kodilla.sudoku.constant.Data;
import com.kodilla.sudoku.constant.TemplateBoards;
import com.kodilla.sudoku.field.SudokuBoard;
import com.kodilla.sudoku.solver.Solver;
import com.kodilla.sudoku.solver.algorithm.Validator;

public class TemplateGame implements Gameable {
    private final Terminal terminal;

    public TemplateGame() {
        terminal = new Terminal();
    }

    @Override
    public boolean resolveSudoku() {
        boolean newGame = terminal.startNewGame();
        if (newGame) {
            startGame();
        }
        return !newGame;
    }

    @Override
    public void startGame() {
        SudokuBoard sudokuBoard = TemplateBoards.getSudokuTemplate();
        System.out.println("Sudoku before resolve:");
        sudokuBoard.print();
        if (Validator.checkSudoku(sudokuBoard)) {
            run(sudokuBoard);
        } else {
            terminal.printInputSudokuError();
        }
    }

    private void run(SudokuBoard sudokuBoard) {
        Solver solver = new Solver(sudokuBoard);

        if (solver.process()) {
            terminal.printSolution();
            sudokuBoard = solver.getSudokuBoard();
            sudokuBoard.print();
            System.out.println(Data.LEGEND);
        } else {
            terminal.printNoSolution();
        }
    }
}
