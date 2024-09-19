package com.dsa.recursion;

public class Fibonacci {

    public static void main(String[] args) {

        System.out.println(fibonacci(6));
    }

    static int fibonacci(int n) {

        //base condition
        if (n < 2) {
            return n;
        }

        int firstLast = fibonacci(n - 1);
        int secondLast = fibonacci(n - 2);

        return firstLast + secondLast;
    }
}
