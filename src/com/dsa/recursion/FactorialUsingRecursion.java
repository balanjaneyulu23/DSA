package com.dsa.recursion;

public class FactorialUsingRecursion {

    public static void main(String[] args) {
        System.out.println(fact(3));
    }

    /**
     * this method is meant to return factorial of a given number
     * @param num
     * @return
     */
    static int fact(int num) {
        if (num == 1) {
            return num;
        }
        return num * fact(num - 1);
    }
}
