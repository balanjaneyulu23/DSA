package com.dsa.recursion.backtracking;

public class Knights {
    public static void main(String[] args) {
        int n = 4;
        int knight = 4;
        boolean[][] board = new boolean[n][n];
        knightsSolver(board, 0, 0, 4);

    }

    static void knightsSolver(boolean[][] board, int row, int col, int knight) {
        //display board if all knights are placed in the board
        if (knight == 0) {
            display(board);
            System.out.println();
            return;
        }

        // row and col are reached board size then exit
        if (row == board.length - 1 && col == board.length) {
            return;
        }

        if (col == board.length) {
            knightsSolver(board, row + 1, 0, knight);
            return;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            knightsSolver(board, row, col + 1, knight - 1);
            board[row][col] = false;
        }

        knightsSolver(board, row, col + 1, knight);

    }

    /**
     * Check whether that particular cell is safe to place knight or not
     *
     * @param board
     * @param row
     * @param col
     * @return
     */
    private static boolean isSafe(boolean[][] board, int row, int col) {

        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }

        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }

        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }

        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }

        return true;
    }

    private static boolean isValid(boolean[][] board, int row, int col) {
        return (row >= 0 && row < board.length) && (col >= 0 && col < board.length);
    }

    /**
     * Displaying elements in boolean 2D array
     */
    private static void display(boolean[][] board) {
        for (boolean[] arr : board) {
            for (boolean element : arr) {
                if (element) {
                    System.out.print("K");
                } else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }


}
