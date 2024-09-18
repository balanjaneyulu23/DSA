package com.dsa.recursion;

public class Fibonacci {
    public static void main(String[] args) {

        System.out.println("Fibonacci : "+fibonacci(8));
    }

    static int fibonacci(int n) {

        if (n <= 1) {
            return n;
        }

        int firstLast = fibonacci(n - 1);
        int secondLast = fibonacci(n - 2);
        return firstLast + secondLast;
    }
}
