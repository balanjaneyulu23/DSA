package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class Maze {

    public static void main(String[] args) {

        // System.out.println(countNofWays(3, 3));
        //System.out.println(getPaths("", 3, 3));
        boolean[][] board = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };

        pathObstacles("", board, 0, 0);
    }

    /**
     * this method returns no of ways to reach point A to point B
     *
     * @return
     */
    static int countNofWays(int row, int col) {
        if (row == 1 || col == 1) {
            return 1;
        }
        int down = countNofWays(row - 1, col);
        int right = countNofWays(row, col - 1);
        return down + right;
    }


    /**
     * this method is meant to print nof of paths to reach point A to point B
     * D-diagnally
     * V-down
     * H-for horizontally
     *
     * @param p
     * @param row
     * @param col
     */
    static List<String> getPaths(String p, int row, int col) {
        if (row == 1 && col == 1) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> ans = new ArrayList<>();

        if (row > 1 && col > 1) {
            ans.addAll(getPaths(p + 'D', row - 1, col - 1));
        }
        if (row > 1) {
            ans.addAll(getPaths(p + 'V', row - 1, col));
        }

        if (col > 1) {
            ans.addAll(getPaths(p + 'H', row, col - 1));
        }
        return ans;
    }


    /**
     * this method is meant to return paths when there is a obstacles in paths
     *
     * @param p
     * @param maze
     * @param row
     * @param col
     */
    static void pathObstacles(String p, boolean[][] maze, int row, int col) {

        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (!maze[row][col]) {
            return;
        }

        if (row < maze.length - 1) {
            pathObstacles(p + 'D', maze, row + 1, col);
        }

        if (col < maze[0].length - 1) {
            pathObstacles(p + 'R', maze, row, col + 1);
        }

    }

}
