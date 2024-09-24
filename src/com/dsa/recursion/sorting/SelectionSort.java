package com.dsa.recursion.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {

        int[] arr = {4, 3, 2, 1};
        sort(arr, arr.length, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int row, int col, int maxIndex) {

        if (row == 0) {
            return;
        }

        if (col < row) {

            if (arr[col] > arr[maxIndex]) {
                maxIndex = col;
            }

            sort(arr, row, col + 1, maxIndex);
        } else {
            // swap max element in last index of an array
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[row-1];
            arr[row-1] = temp;

            sort(arr, row - 1, 0, 0);
        }

    }
}
