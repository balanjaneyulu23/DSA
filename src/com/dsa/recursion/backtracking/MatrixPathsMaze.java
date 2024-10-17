package com.dsa.recursion.backtracking;

import java.util.Arrays;

public class MatrixPathsMaze {

    public static void main(String[] args) {

        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        int[][] paths = new int[board.length][board[0].length];
        AllPaths("", board, 0, 0, paths, 1);
    }

    static void AllPaths(String p, boolean[][] maze, int row, int col, int[][] paths, int steps) {

        if (row == maze.length - 1 && col == maze[0].length - 1) {
            paths[row][col] = steps;
            for (int[] arr : paths) {
                System.out.println(Arrays.toString(arr));
            }

            System.out.println(p);
            System.out.println();
            return;
        }

        if (!maze[row][col]) {
            return;
        }

        // considering this block in my path
        maze[row][col] = false;
        paths[row][col] = steps;

        if (row < maze.length - 1) {
            AllPaths(p + 'D', maze, row + 1, col, paths, steps + 1);
        }

        if (col < maze[0].length - 1) {
            AllPaths(p + 'R', maze, row, col + 1, paths, steps + 1);
        }

        if (row > 0) {
            AllPaths(p + 'U', maze, row - 1, col, paths, steps + 1);
        }

        if (col > 0) {
            AllPaths(p + 'R', maze, row, col - 1, paths, steps + 1);
        }
        // this line is where function will be over
        // so before function gets removed , also remove the changes that were made by that function
        maze[row][col] = true;
        paths[row][col] = 0;
    }

}
