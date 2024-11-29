package com.dsa.striversa2z.step2_1.sorting;

import java.util.Arrays;

public class Sorting_1 {
    public static void main(String[] args) {

        int[] arr = {13, 46, 24, 52, 20, 9};
        //sortUsingSelectionSort(arr);
       // sortUsingBubbleSort(arr);
        sortUsingInsertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * This method is meant to sort an array using selection sort
     *
     * @param arr
     */
    public static void sortUsingSelectionSort(int[] arr) {
        int arrSize = arr.length;
        for (int i = 0; i < arrSize; i++) {
            int minEleInd = i;
            for (int j = i + 1; j < arrSize; j++) {
                if (arr[j] < arr[minEleInd]) {
                    minEleInd = j;
                }
            }

            if (minEleInd != i) {
                swap(arr, i, minEleInd);
            }
        }

    }

    /**
     * This method is meant to sort an array using Bubble sort
     *
     * @param arr
     */
    public static void sortUsingBubbleSort(int[] arr) {
        int arrSize = arr.length;
        for (int i = 0; i < arrSize; i++) {
            int didSwap = 0;
            for (int j = 1; j < arrSize - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    didSwap = 1;
                }
            }
            if (didSwap == 1) {
                break;
            }
        }

    }

    /**
     * This method is meant to sort an array using insertion sort
     * @param arr
     */
    public static void sortUsingInsertionSort(int[] arr) {
        int arrSize = arr.length;
        for (int i = 0; i < arrSize; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }

    }

    private static void swap(int[] arr, int i, int minEleInd) {
        int temp = arr[i];
        arr[i] = arr[minEleInd];
        arr[minEleInd] = temp;
    }


}
