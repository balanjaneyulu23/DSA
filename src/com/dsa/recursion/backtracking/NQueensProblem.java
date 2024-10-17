package com.dsa.recursion.backtracking;

public class NQueensProblem {

    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(queen(board,0));

    }

    /**
     * this method is used to implement N queen problem using recursion backtracking
     *
     * @param board
     * @param row
     * @return
     */
    static int queen(boolean[][] board, int row) {

        if (row == board.length) {
            displayBoard(board);
            return 1;
        }

        int count = 0;
        //placing the queen and checking in the safe cell
        for (int col = 0; col < board.length; col++) {

            // check if the cell where queen is placing is safe or not
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count = count + queen(board, row + 1);
                board[row][col] = false;
            }
        }

        return count;
    }


    /**
     * This method is meant to check weather
     *
     * @param board
     * @param row
     * @param col
     * @return
     */
    private static boolean isSafe(boolean[][] board, int row, int col) {

        //checking vertical cells whether those cells are safe or not
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // checking left diagonal cell weather those cells are safe or not
        int leftMax = Math.min(row, col);
        for (int i = 1; i <= leftMax; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }


        //checking right diagonal  cells whether those cells are safe or not
        int rightMax = Math.min(row, board.length - col - 1);
        for (int i = 1; i <=rightMax; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * this method is to print all elements in the board
     *
     * @param board
     */
    private static void displayBoard(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("Q");
                } else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }
}
