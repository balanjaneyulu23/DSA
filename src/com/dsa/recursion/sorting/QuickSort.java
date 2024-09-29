package com.dsa.recursion.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        //  int[] arr = {4,4, 1, 7, 9, 3};

        int[] arr = {4, 6, 2, 5, 7, 9, 1, 3, 4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            // it will pick pivot and place it in correct position
            int p = partitionIndex(arr, low, high);
            // left side array
            quickSort(arr, low, p - 1);
            //right side array
            quickSort(arr, p + 1, high);
        }

    }

    /**
     * This method picks pivot element and place it in
     * it's correct position in first pass
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    static int partitionIndex(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        int pivot = arr[low];

        while (i < j) {

            while (i <= high && arr[i] <= pivot) {
                i++;
            }

            while (j >= low && arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }

        swap(arr, low, j);
        return j;
    }

    /**
     * swap the elements
     *
     * @param firstElmt
     * @param secondElmt
     */
    static void swap(int[] arr, int firstElmt, int secondElmt) {
        int temp = arr[firstElmt];
        arr[firstElmt] = arr[secondElmt];
        arr[secondElmt] = temp;
    }

}
