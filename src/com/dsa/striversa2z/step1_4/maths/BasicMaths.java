package com.dsa.striversa2z.step1_4.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BasicMaths {

    public static void main(String[] args) {

        // System.out.println(evenlyDivides(23));
        // System.out.println(countDigits(2446));
        // System.out.println(reverseOfNumber(-123));
        //  System.out.println(isAmstrongNumber(93084));
        // printDivisors(36);
        // System.out.println(sumOfDivisors(4));
        //System.out.println(isPrime(21));
        //System.out.println(gcd(11, 13));
        System.out.println(Arrays.toString(lcmAndGcd(5,10)));

    }

    /**
     * Geeks for geeks problem
     * https://www.geeksforgeeks.org/problems/count-digits5716/1
     *
     * @param n
     * @return
     */
    static int evenlyDivides(int n) {
        int count = 0;
        int number = n;
        while (n > 0) {
            int lastDigit = n % 10;
            if (lastDigit != 0 && number % lastDigit == 0) {
                count++;
            }
            n = n / 10;
        }
        return count;
    }

    static int countDigits(int n) {
        return (int) (Math.log10(n) + 1);
    }

    /**
     * https://leetcode.com/problems/reverse-integer/
     *
     * @param x
     * @return
     */
    static int reverseOfNumber(int x) {

        int reverse = 0;
        while (x != 0) {
            int lastDigit = x % 10;

            // overflow of Int range check
            if (reverse < Integer.MIN_VALUE / 10 || reverse > Integer.MAX_VALUE / 10) {
                return 0;
            }
            reverse = reverse * 10 + lastDigit;
            x = x / 10;
        }

        return reverse;
    }


    /**
     * https://leetcode.com/problems/palindrome-number/description/
     *
     * @param x
     * @return
     */
    static boolean isPalindrom(int x) {
        int number = x;

        if (x < 0) {
            return false;
        }
        int reverseOfNumber = 0;
        while (x > 0) {
            int lastDigit = x % 10;
            reverseOfNumber = reverseOfNumber * 10 + lastDigit;
            x = x / 10;
        }
        return number == reverseOfNumber;
    }

    /**
     * https://leetcode.com/problems/armstrong-number/description/
     *
     * @param n
     * @return
     */
    static boolean isAmstrongNumber(int n) {
        int num = n;
        int sum = 0;
        int countOfDigits = (int) Math.log10(num) + 1;
        while (n > 0) {
            int lastDigit = n % 10;
            sum = sum + (int) Math.pow(lastDigit, countOfDigits);
            n = n / 10;
        }
        return num == sum;
    }

    /**
     * print all divisors of a given number N
     *
     * @param n
     */
    static void printDivisors(int n) {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                if (n / i != i) {
                    list.add(n / i);
                }
            }
        }
        list.stream().sorted().forEach(System.out::println);
    }

    /**
     * https://www.geeksforgeeks.org/problems/sum-of-all-divisors-from-1-to-n4738/1
     *
     * @param n
     * @return
     */
    public static long sumOfDivisors(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i * (n / i);
        }
        return sum;
    }

    public static boolean isPrime(int n) {
        int cnt = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                cnt++;

                if (n / i != i) {
                    cnt++;
                }
            }
        }
        return cnt == 2;
    }

    /**
     * GCD of a given two numbers a, b
     *
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        if (a == 0) {
            return b;
        }
        return a;
    }

    /**
     * https://www.geeksforgeeks.org/problems/lcm-and-gcd4516/1
     * @param a
     * @param b
     * @return
     */
    public static int[] lcmAndGcd(int a, int b) {

        int prod =a*b;
        int[] list = new int[2];
        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }

        int gcd = a == 0 ? b : a;
        int lcm = prod/ gcd;

        list[0] = lcm;
        list[1] = gcd;
        return list;
    }
}
