package com.dsa.recursion;

public class MazeAllPaths {
    public static void main(String[] args) {

        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        AllPaths("", board, 0, 0);
    }

    static void AllPaths(String p, boolean[][] maze, int row, int col) {

        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        // check this cell is visited or not. If visited then return or else continue
        if (!maze[row][col]) {
            return;
        }

        // considering this cell is in my path and visiting
        // hence make it has false so that never going to visit that cell again
        maze[row][col] = false;

        //moving down hence row is increasing
        if (row < maze.length - 1) {
            AllPaths(p + 'D', maze, row + 1, col);
        }

        //moving right hence col is increasing
        if (col < maze[0].length - 1) {
            AllPaths(p + 'R', maze, row, col + 1);
        }

        // moving up that means row is decreasing
        if (row > 0) {
            AllPaths(p + 'U', maze, row - 1, col);
        }

        //moving left means col value is decreasing
        if (col > 0) {
            AllPaths(p + 'L', maze, row, col - 1);
        }
        // this line is where function will be over
        // so before function gets removed , also remove the changes that were made by that function
        maze[row][col] = true;
    }

}
