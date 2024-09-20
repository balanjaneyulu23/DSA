package com.dsa.recursion;

public class ProductOfNumbers {

    public static void main(String[] args) {

        System.out.println("product of numbers "+productOfNumber(505));
    }

    static int productOfNumber(int n) {
        if (n % 10 == n) {
            return n;
        }

        return (n % 10) * productOfNumber(n / 10);

    }
}
