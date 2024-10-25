package com.dsa.recursion.backtracking;

public class SudokuSolver {
    public static void main(String[] args) {

        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (sudokuSolver(board)) {
            display(board);
        } else {
            System.out.println("Could not solve the board");
        }
    }

    /**
     * This method is meant to solve suduko. If all recursive call of this method
     * is return true then suduko is solved. If any recursive call return false then
     * backtrack
     *
     * @param board
     * @return
     */
    static boolean sudokuSolver(int[][] board) {

        int n = board.length;
        int row = -1;
        int col = -1;

        //Initial assumption that there is no empty cell left
        boolean emptyLeft = true;
        // determining any empty cell is present in given board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    emptyLeft = false;
                    row = i;
                    col = j;
                    break;
                }
            }

            if (!emptyLeft) {
                break;
            }
        }

        //If there is empty cell present in board then
        // sudoku is solved
        if (emptyLeft) {
            return true;
        }

        // filling the numbers in empty cells in the board
        for (int number = 1; number <= n; number++) {
            if (isSafe(board, row, col, number)) {
                board[row][col] = number;
                if (sudokuSolver(board)) {
                    //found the answer
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    /**
     * This method is meant for checking particular cell in the board that
     * whether the the number given as as input argument to this method is safe
     * to fill in the cell or not
     *
     * @param board
     * @param row
     * @param col
     * @param number
     * @return
     */
    static boolean isSafe(int[][] board, int row, int col, int number) {
        //As per the  Sukudo first condition, checking whether given number is
        // present in the same row or not
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == number) {
                return false;
            }
        }

        //As per the  Sukudo second condition, checking whether given number is
        // present in the same column or not
        for (int[] ints : board) {
            if (ints[col] == number) {
                return false;
            }
        }

        //As per the  Sukudo third condition, checking whether given number is
        // present in the same box of 3*3 in 9*9 grid or not
        int sqrt = (int) Math.sqrt(board.length);
        int startRow = row - row % sqrt;
        int startCol = col - col % sqrt;

        //iterating and checking each row and column of the same 3*3 box
        for (int r = startRow; r < startRow + sqrt; r++) {
            for (int c = startCol; c < startCol + sqrt; c++) {
                if (board[r][c] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This method is meant to display 2d board
     *
     * @param board
     */
    static void display(int[][] board) {
        for (int[] row : board) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }

    }
}
