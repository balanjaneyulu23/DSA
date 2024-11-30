package com.dsa.striversa2z.step2_1.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorting_2 {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 6, 7};
        //mergeSort(arr, 0, arr.length - 1);
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Merge sort to sort an array
     *
     * @param arr
     * @param low
     * @param high
     */
    static void mergeSort(int[] arr, int low, int high) {

        // when low and high both are pointing single element then only
        // this below base condition would be true
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;
        //left part of the array
        mergeSort(arr, low, mid);
        //right part of the array
        mergeSort(arr, mid + 1, high);
        // merge method to sort two parts of array and merge them
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {

            // compare first element in left sub array with first element in right sub array
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // add left over elements in left array
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // add left over elements in right array
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        //copying elements from temp to original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            //finding the partition index
            int pIndex = partition(arr, low, high);

            //left part of the array which is left part to Partition Index
            quickSort(arr, low, pIndex - 1);
            //Right part of the array which is right part to Partition Index
            quickSort(arr, pIndex + 1, high);
        }

    }

    private static int partition(int[] arr, int low, int high) {
        //let's consider first element in this range as a pivot
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (i <= high-1 && arr[i] <= pivot) {
                i++;
            }
            while (j >= low + 1 && arr[j] > pivot) {
                j--;
            }

            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
