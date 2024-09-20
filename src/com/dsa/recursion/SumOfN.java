package com.dsa.recursion;

public class SumOfN {

    public static void main(String[] args) {

        System.out.println("sum of n : " + sum(5));
    }

    /**
     * sum of the given n number
     *
     * @param n
     * @param sum
     * @return
     */
    static int sum(int n) {

        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);

    }
}
