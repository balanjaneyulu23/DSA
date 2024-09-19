package com.dsa.recursion;

public class NumbersExample {
    public static void main(String[] args) {

        print(1);
    }


    /**
     * this method will demonstrate simple recursion function with base condition
     * @param n
     */
    static void print(int n) {

        if (n == 5) {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        print(n + 1);

    }

}
