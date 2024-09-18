package com.dsa.recursion;

/**
 * this program will print sum of the given number N
 */
public class SumOfNumbers_Recursion {

    public static void main(String[] args) {
       // sumOfNumber(3, 0);
        System.out.println(sumOfNumber(3));
    }

    /**
     * this method is meant to print sum of the given number using parameterized way
     * i.e carrying sum variable and given number N as a function parameters
     */
    static void sumOfNumber(int number, int sum) {
        if (number < 1) {
            System.out.println("sum would be : " + sum);
            return;
        }
        sumOfNumber(number - 1, sum + number);
    }

    /**
     * this method is meant to print sum of the given number using functional way
     * i.e carrying  given number N as a function parameter and return results of sum
     * n+func(n-1)
     */
    static int sumOfNumber(int number) {
        if (number == 0) {
            return number;
        }
        return number + sumOfNumber(number-1);
    }
}
