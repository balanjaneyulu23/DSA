package com.dsa.striversa2z.step1_2;

public class Patterns {

    public static void main(String[] args) {
        pattern1(4, 4);
    }

    public static void pattern1(int row, int col) {

        //outer loop
        for (int i = 0; i < row; i++) {
            // inner loop
            for (int j = 0; j < col; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
