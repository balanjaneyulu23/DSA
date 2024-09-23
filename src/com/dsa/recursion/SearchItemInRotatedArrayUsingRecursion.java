package com.dsa.recursion;

public class SearchItemInRotatedArrayUsingRecursion {
    public static void main(String[] args) {

        int [] arr={7,8,9,1,2,3,4,5,6};
        System.out.println(search(arr,10,0,arr.length-1));
    }

    static int search(int[] arr, int target, int start, int end) {

        if (start > end) {
            return -1;
        }

        int mid = start + (end-start) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        // checking left part is sorted
        if (arr[start] <= arr[mid]) {
            //check key is lie in left part
            if (arr[start] <= target && target <= arr[mid]) {
                return search(arr, target, start, mid - 1);
            } else {
                return search(arr, target, mid + 1, end);
            }
        } else {

            if (target >= arr[mid] && target <= arr[end]) {
                return search(arr, target, mid + 1, end);
            } else {

                return search(arr, target, start, mid - 1);
            }
        }

    }
}
