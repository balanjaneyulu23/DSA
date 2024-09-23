package com.dsa.recursion;

public class CountZerosOfNumber {
    public static void main(String[] args) {

        System.out.println(" No of zeros : " + countZeros(0));
    }


    static int countZeros(int n) {
        return helper(n, 0);
    }

    /**
     * this method is meant to count no of zero's of a given number
     * Here in base condition count value which is returned ,
     * will be passed to every recursive calls
     *
     * @param n
     * @param count
     * @return
     */
    static int helper(int n, int count) {
        if (n == 0) {
            return count;
        }

        int rem = n % 10;
        if (rem == 0) {
            return helper(n / 10, count + 1);
        }
        return helper(n / 10, count);

    }
}
