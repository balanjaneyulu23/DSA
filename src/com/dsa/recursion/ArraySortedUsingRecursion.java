package com.dsa.recursion;

public class ArraySortedUsingRecursion {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6,9,8};
        System.out.println(isArraySorted(arr, 0));
    }

    static boolean isArraySorted(int[] arr, int index) {
        if (index == arr.length - 1) {
            return true;
        }

        return arr[index] < arr[index + 1] && isArraySorted(arr, index + 1);
    }

}
