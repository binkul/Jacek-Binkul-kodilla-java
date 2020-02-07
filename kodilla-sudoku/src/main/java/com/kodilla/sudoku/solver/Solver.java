package com.kodilla.sudoku.solver;

import com.kodilla.sudoku.constant.Data;
import com.kodilla.sudoku.field.SudokuBoard;
import com.kodilla.sudoku.field.SudokuElement;
import com.kodilla.sudoku.field.SudokuRow;
import com.kodilla.sudoku.solver.algorithm.Result;
import com.kodilla.sudoku.solver.algorithm.SolverBackTrack;
import com.kodilla.sudoku.solver.algorithm.SolverStandard;

import java.util.Collection;

public class Solver {
    private SudokuBoard sudokuBoard;
    private final SolverStandard solverStandard;
    private final SolverBackTrack solverBackTrack;

    public Solver(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
        solverStandard = new SolverStandard();
        solverBackTrack = new SolverBackTrack(this);
    }

    public boolean process() {
        runStandard(sudokuBoard);
        Result enterRun = runStandard(sudokuBoard);
        if (enterRun == Result.FULL_FILLED) {
            return true;
        } else {
            return solverBackTrack.process(sudokuBoard);
        }
    }

    public Result runStandard(SudokuBoard sudokuBoard) {
        int count;
        Result result;

        do {
            count = 0;
            for (int row = 0; row < Data.DIMENSION; row++) {
                for (int column = 0; column < Data.DIMENSION; column++) {
                    result = solverStandard.process(sudokuBoard, row, column);
                    if (result == Result.ERROR) return result;
                    if (result == Result.ADDED) count++;
                }
            }
        } while (count != 0);
        return isBoardFilled(sudokuBoard) ? Result.FULL_FILLED : Result.NONE;
    }

    private boolean isBoardFilled(SudokuBoard sudokuBoard) {
        return sudokuBoard.getRows().stream()
                .map(SudokuRow::getSudokuRow)
                .flatMap(Collection::stream)
                .map(SudokuElement::getNumber)
                .noneMatch(i -> i == Data.EMPTY);
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public void setSudokuBoard(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }
}
