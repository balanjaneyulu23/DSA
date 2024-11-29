package com.dsa.striversa2z.step1_5.recursion;

import java.util.Arrays;
import java.util.IllegalFormatCodePointException;

public class BasicRecursion {
    public static void main(String[] args) {
        // func();
        // print1ToN(10);
        // printNameNtimes(5);
        // printNumbersFromNto1(10);
        // print1toN(5, 5);
        //printNto1(1, 5);
        //sumParamWay(3, 0);
        //System.out.println(sumFuncWay(3));
        // System.out.println(factorial(3));
        // System.out.println(sumOfSeries(5));
        // int[] arr = {1, 2, 3, 4, 5};
        //reverseArrayOneWay(arr, 0, arr.length - 1);
        // reverseArraySinglePointer(arr, 0);
        // System.out.println(Arrays.toString(arr));
        //System.out.println(isPalindrome("ab_a"));
        System.out.println(fibonacci(8));

    }

    static void func() {
        System.out.println(1);
        func();
    }

    static int cnt = 1;

    /**
     * This method is meant to print numbers from 1 to N
     *
     * @param n
     */
    static void print1ToN(int n) {
        if (cnt > n) {
            return;
        }

        System.out.println(cnt);
        cnt++;
        print1ToN(n);
    }


    /**
     * This method is meant to print name 5 times
     *
     * @param n
     */
    static void printNameNtimes(int n) {
        if (cnt > n) {
            return;
        }
        System.out.print("Balanjaneyulu ");
        cnt++;
        printNameNtimes(n);
    }

    static void printNumbersFromNto1(int n) {
        if (n <= 0) {
            return;
        }

        System.out.print(n);
        System.out.print(" ");
        printNumbersFromNto1(n - 1);
    }

    /**
     * This function is meant to print numbers from 1 to N using recursion back track
     *
     * @param i
     * @param n
     */
    static void print1toN(int i, int n) {
        if (i < 1) {
            return;
        }

        print1toN(i - 1, n);
        System.out.print(i);
        System.out.println(" ");
    }

    /**
     * Printing numbers from N to 1 using recursion back track
     *
     * @param i
     * @param n
     */
    static void printNto1(int i, int n) {
        if (i > n) {
            return;
        }
        printNto1(i + 1, n);
        System.out.print(i + " ");
    }

    /**
     * This method will print sum of N numbers using parameterized way
     *
     * @param n
     * @param sum
     */
    public static void sumParamWay(int n, int sum) {
        if (n < 1) {
            System.out.print("Sum " + sum);
            return;
        }
        sumParamWay(n - 1, sum + n);
    }

    /**
     * This method is meant to return sum of a n numbers using functional way
     *
     * @param n
     * @return
     */
    public static int sumFuncWay(int n) {
        if (n == 0) {
            return n;
        }
        return n + sumFuncWay(n - 1);

    }

    /**
     * This method is meant for returning factorial of a given number N
     *
     * @param n
     * @return
     */
    public static int factorial(int n) {
        if (n == 1) {
            return n;
        }

        return n * factorial(n - 1);
    }

    public static long sumOfSeries(long n) {
        if (n == 0) {
            return n;
        }
        return n * n * n + sumOfSeries(n - 1);
    }

    /**
     * This method is meant for two pointer approach
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void reverseArrayOneWay(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }

        swap(arr, start, end);
        reverseArrayOneWay(arr, start + 1, end - 1);
    }

    /**
     * This method is meant for reversing an array using single pointer method
     */
    public static void reverseArraySinglePointer(int[] arr, int i) {
        int n = arr.length;
        if (i >= n / 2) {
            return;
        }
        swap(arr, i, n - i - 1);
        reverseArraySinglePointer(arr, i + 1);
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    /**
     * To check given string is a palindrome or not
     */
    static boolean isPalindrome(String input) {
        input = input.replaceAll("[^A-Za-z0-9]", "")
                .toLowerCase();
        return palindromHelper(input, 0);
    }

    private static boolean palindromHelper(String input, int i) {
        int n = input.length();
        if (i >= n - i - 1) {
            return true;
        }

        System.out.println(input.charAt(i));
        System.out.println(input.charAt(n - i - 1));
        if (input.charAt(i) != input.charAt(n - i - 1)) {
            return false;
        }

        return palindromHelper(input, i + 1);
    }

    /**
     * This method is meant to return nth fibonacci number
     * @param n
     * @return
     */
   static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int last = fibonacci(n - 1);
        int secondLast = fibonacci(n - 2);
        return last + secondLast;
    }
}
