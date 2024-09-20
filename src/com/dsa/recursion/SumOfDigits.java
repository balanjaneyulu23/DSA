package com.dsa.recursion;

public class SumOfDigits {
    public static void main(String[] args) {

        System.out.println("Sum of digits: "+ sumOfDigits(1342));
    }

    static  int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return sumOfDigits(n / 10) + n % 10;
    }
}
