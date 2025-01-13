package com.dsa.striversa2z.step4_1;

import java.util.Arrays;

public class BinarySearchOn1DArrays {

    public static void main(String[] args) {

        int[] nums = {1,3,5,6};
        System.out.println(getCeil(5, nums));

    }


    public static int search(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    static int search(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (target == nums[mid]) return mid;
        if (nums[mid] > target) {
            return search(nums, low, mid - 1, target);
        } else {
            return search(nums, mid + 1, high, target);
        }
    }

    static int findFloor(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= k) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    static int getCeil(int x, int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int[] getFloorAndCeil(int x, int[] arr) {
        Arrays.sort(arr);
        int floor = findFloor(arr, x);
        if (floor != -1) {
            floor = arr[floor];
        }

        int ceil = getCeil(x, arr);
        if (ceil != -1) {
            ceil = arr[ceil];
        }
        return new int[]{floor, ceil};
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
