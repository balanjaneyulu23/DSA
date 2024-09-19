package com.dsa.recursion;

public class RecursionBasicProblems {

    public static void main(String[] args) {

        //printNto1(5);
        //print1toN(5);
        printbothNto1And1to5(5);
    }


    /**
     * print N to 1 and print 1 to N
     *
     * @param n
     */
    static void printbothNto1And1to5(int n) {

        if (n < 1) {
            return;
        }

        System.out.print(n + " ");
        printbothNto1And1to5(n - 1);

        System.out.print(n + " ");

    }

    /**
     * this method is printing numbers from N to 1 using recursion
     *
     * @param n
     */
    static void printNto1(int n) {
        if (n < 1) {
            return;
        }

        System.out.println(n);
        printNto1(n - 1);
    }


    /**
     * this method is meant to print numbers from 1 to N using recursion
     *
     * @param n
     */
    static void print1toN(int n) {
        if (n < 1) {
            return;
        }

        print1toN(n - 1);
        System.out.println(n);

    }
}
