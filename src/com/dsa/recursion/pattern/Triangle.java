package com.dsa.recursion.pattern;

public class Triangle {
    public static void main(String[] args) {
        printTriagle(4, 0);
    }

    static void printTriagle(int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            System.out.print(" * ");
            printTriagle(row, col + 1);
        } else {
            System.out.println();
            printTriagle(row - 1, 0);
        }

    }
}
