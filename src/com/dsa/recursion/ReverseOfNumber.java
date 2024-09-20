package com.dsa.recursion;

public class ReverseOfNumber {
    public static void main(String[] args) {

        System.out.println("Reverse of a number "+ reverseOfNumber(1234));
    }

    static int reverseOfNumber(int n) {
        //this line will return no of digits of a given number
        int digits = (int) (Math.log10(n)) + 1;
        return helper(n, digits);

    }

    private static int helper(int n, int digits) {

        if (n % 10 == n) {
            return n;
        }
        int remainder = n % 10;
        return remainder * (int) (Math.pow(10, digits - 1)) +
                helper(n / 10, digits - 1);
    }
}
