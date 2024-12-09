package com.dsa.striversa2z.step3_1.easy;

import java.util.*;

public class EasyArrayProblems {
    public static void main(String[] args) {

        int[] arr = {2, 0, 0, 3};
        // int[] a = {1, 2, 3, 4, 5};
        //int[] b = {1, 2, 3, 6, 7};
        // System.out.println(removeDuplicateUsingBruetForce(arr));
        // rotateArrayRightByKStepsOptimalApproach(arr, 3);
        //moveZeroes(arr);
        // System.out.println(findUnion(a, b));
        // System.out.println(findIntersection(a, b));
        //System.out.println(Arrays.toString(arr));
        // System.out.println(missingNumber(arr));
        System.out.println(lenOfLongestSubarrOptimalForPositiveNum(arr, 3));
    }

    /**
     * Finding largest element in a given array
     *
     * @param arr
     * @return
     */
    static int maxEleInArray(int[] arr) {
        int maxEle = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxEle) {
                maxEle = arr[i];
            }
        }
        return maxEle;
    }

    /**
     * Second largest element in a given  array
     *
     * @param arr
     * @return
     */
    static int secondMaxEleInArr(int[] arr) {
        int maxEle = arr[0];
        int secondMaxEle = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxEle) {
                secondMaxEle = maxEle;
                maxEle = arr[i];
            }
            if (arr[i] != maxEle && arr[i] > secondMaxEle) {
                secondMaxEle = arr[i];
            }
        }
        return secondMaxEle;
    }

    /**
     * Check If array is sorted or not
     *
     * @param arr
     * @return
     */
    static boolean isArraySorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i])
                return false;
        }
        return true;
    }

    /**
     * return number of unique elements in an array-two pointer approach
     * Optimal approach
     *
     * @param arr
     * @return
     */
    static int removeDuplicatesInArray(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                arr[i + 1] = arr[j];
                i = i + 1;
            }
        }

        return i + 1;
    }

    /**
     * return number of unique elements in an array-two pointer approach
     * Optimal approach
     *
     * @param arr
     * @return
     */
    static int removeDuplicateUsingBruetForce(int[] arr) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        Object[] arrtemp = set.toArray();
        for (int i = 0; i < arrtemp.length; i++) {
            arr[i] = (int) arrtemp[i];
        }
        return set.size();
    }

    /**
     * Rotate the array to the right by k steps, where k is non-negative.
     * Brueth force approach
     *
     * @param nums
     * @param k
     */
    static void rotateArrayRightByKStepsBruethForceApproach(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            int temp = nums[n - 1];
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    /**
     * Rotate the array to the right by k steps, where k is non-negative
     * Optimal approach
     *
     * @param nums
     * @param k
     */
    static void rotateArrayRightByKStepsOptimalApproach(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        // Step1: Reverse last k elements ,range of last k elements are (n-k) (and n-1)
        reverse(nums, n - k, n - 1);
        //Step2: Reverse first n-k elements, Range would be 0 to n-k
        reverse(nums, 0, (n - 1) - k);
        //Step3: Reverse whole array range from 0 to n-1
        reverse(nums, 0, n - 1);
    }

    /**
     * Move Zeroes to end
     * Given an integer array nums, move all 0's to the end of
     * it while maintaining the relative order of the non-zero elements
     * Optimal Approach
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        if (j == -1) {
            return;
        }

        for (int i = j + 1; i < n; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Reverse a given array
     *
     * @param nums
     */
    private static void reverse(int[] nums, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }

    public static List<Integer> findUnion(int[] a, int[] b) {
        int sizeOfA = a.length;
        int sizeOfB = b.length;
        List<Integer> unionList = new ArrayList<>();
        int initialIndOfA = 0;
        int initialIndOfB = 0;

        while (initialIndOfA < sizeOfA && initialIndOfB < sizeOfB) {
            if (a[initialIndOfA] <= b[initialIndOfB]) {
                if (unionList.size() == 0 || unionList.get(unionList.size() - 1) != a[initialIndOfA]) {
                    unionList.add(a[initialIndOfA]);
                }
                initialIndOfA++;
            } else {
                if (unionList.size() == 0 || unionList.get(unionList.size() - 1) != b[initialIndOfB]) {
                    unionList.add(b[initialIndOfB]);
                }
                initialIndOfB++;
            }
        }

        while (initialIndOfA < sizeOfA) {

            if (unionList.size() == 0 || unionList.get(unionList.size() - 1) != a[initialIndOfA]) {
                unionList.add(a[initialIndOfA]);
            }
            initialIndOfA++;
        }

        while (initialIndOfB < sizeOfB) {

            if (unionList.size() == 0 || unionList.get(unionList.size() - 1) != b[initialIndOfB]) {
                unionList.add(b[initialIndOfB]);
            }
            initialIndOfB++;
        }
        return unionList;
    }

    /**
     * finding intersection of two sorted arrays
     *
     * @param a
     * @param b
     * @return
     */
    public static List<Integer> findIntersection(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        int i = 0;
        int j = 0;
        List<Integer> ans = new ArrayList<>();
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                ans.add(a[i]);
                i++;
                j++;
            }
        }
        return ans;
    }

    /**
     * Leet code #268. Missing Number
     *
     * @param nums
     * @return
     */
    static int missingNumber(int[] nums) {
        int n = nums.length;
        // sum of natural numbers
        int sum1 = n * (n + 1) / 2;
        System.out.println("sum1 : " + sum1);
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum2 += nums[i];
        }
        System.out.println("sum2 : " + sum2);
        return sum1 - sum2;
    }

    /**
     * https://leetcode.com/problems/max-consecutive-ones/description/
     *
     * @param nums
     * @return
     */
    static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, maxCount = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                count = 0;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }

    /**
     * Longest Sub-Array with Sum K
     * Source:Geeks for Geeks
     * Approach:Brute Force
     *
     * @param arr
     * @param k
     * @return
     */
    static int lenOfLongestSubarrBrueteForce(int[] arr, int k) {
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    length = Math.max(length, j - i + 1);
                    break;
                }
            }
        }
        return length;
    }

    /**
     * Longest Sub-Array with Sum K and negative and positive
     * Source:Geeks for Geeks
     * Approach:Optimal Approach
     *
     * @param arr
     * @param k
     * @return
     */
    static int lenOfLongestSubarrOptimalApproach(int[] arr, int k) {
        long sum = 0;
        int maxLen = 0;
        Map<Long, Integer> sumLenMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            long rem = sum - k;
            if (sumLenMap.containsKey(rem)) {
                int len = i - sumLenMap.get(rem);
                maxLen = Math.max(len, maxLen);
            }

            if (!sumLenMap.containsKey(sum)) {
                sumLenMap.put(sum, i);
            }

        }
        return maxLen;

    }

    /**
     * Longest Sub-Array with Sum K and  positive integers
     * Source:Geeks for Geeks
     * Approach:Optimal Approach (O(n))
     *
     * @param arr
     * @param k
     * @return
     */
    static int lenOfLongestSubarrOptimalForPositiveNum(int[] arr, int k) {
        int arrSize = arr.length;
        int left = 0, right = 0, maxLen = 0;
        long sum = 0;

        while (right < arrSize) {
            if (sum < k) {
                sum += arr[right];
                right++;
            }

            while (left < right && sum > k) {
                sum -= arr[left];
                left++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left);
                right++;
            }
        }
        return maxLen;
    }

    /**
     * Given a non-empty array of integers nums,
     * every element appears twice except for one. Find that single one
     *
     * @param nums
     * @return
     */
    static int singleNumber(int[] nums, int k) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        return xor;
    }
}
